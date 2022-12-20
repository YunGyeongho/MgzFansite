package com.ho.mgz.login;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ho.mgz.MgzMapper;
import com.ho.mgz.gallery.GalleryDAO;
import com.ho.mgz.gallery.GalleryMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class LoginDAO {

	@Autowired
	private SqlSession ss;
	
	@Autowired
	private GalleryDAO gDAO;
	
	public void getLatestBlock(HttpServletRequest req) {
		// http://192.168.0.158:8976
		HttpURLConnection huc = null;
		try {
			URL u = new URL("http://192.168.0.158:8976/block.get.latest");
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(isr);
			String hash = jo.get("hash").toString();
			req.setAttribute("latestBlockHash", hash);
			
			
		} catch (Exception e) {
		}
		huc.disconnect();
	}
	
	public void join(HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/profilePhoto");
		System.out.println(path);
		MultipartRequest mr = null;

		try {
			mr = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "파일 업로드 실패");
			e.printStackTrace();
			// 업드로한 파일 문제로 인해 가입 실패
			return;
		}

		try {
			// 파일처리
			String photo = mr.getFilesystemName("m_photo");
			photo = URLEncoder.encode(photo, "utf-8").replace("+", " ");

			String id = mr.getParameter("m_id");
			String pw = mr.getParameter("m_pw");
			String nickname = mr.getParameter("m_nickname");

			// 생일
			String yy = mr.getParameter("y");
			String mm = mr.getParameter("m");
			String dd = mr.getParameter("d");
			String ymd = yy + mm + dd;

			Date birthday = new SimpleDateFormat("yyyyMMdd").parse(ymd);

			// 블록
			String block = mr.getParameter("m_block");

			// 주소
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");

			String addr = addr1 + "!" + addr2 + "!" + addr3;

			Member m = new Member(photo, id, pw, nickname, birthday, block, addr);

			// 결과 처리
			if (ss.getMapper(MgzMapper.class).join(m) == 1) {
				req.setAttribute("result", "가입 성공");
			} else {
				req.setAttribute("result", "가입 실패");
				new File(path + "/" + mr.getFilesystemName("m_photo")).delete();
			}
		} catch (Exception e) {
			req.setAttribute("result", "가입 실패");
			e.printStackTrace();
			// DB문제로 인해 가입 실패 시 위에서 업로드 되버린 사진 파일을 삭제
			new File(path + "/" + mr.getFilesystemName("m_photo")).delete();
		}

	}

	public void login(Member inputMember, HttpServletRequest req) {
		try {
			Member dbMember = ss.getMapper(MgzMapper.class).getMemberByID(inputMember);

			if (dbMember != null) {
				if (dbMember.getM_pw().equals(inputMember.getM_pw())) {
					req.getSession().setAttribute("loginMember", dbMember);
				} else {
					req.setAttribute("result", "비밀번호가 일치하지 않습니다.");
				}

			} else {
				req.setAttribute("result", "가입 되지 않은 ID 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "로그인 실패[DB]");
		}

	}

	public boolean loginCheck(HttpServletRequest req) {
		if (req.getSession().getAttribute("loginMember") != null) {
			req.setAttribute("loginPage", "login/welcome.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "login/login.jsp");
			return false;
		}
	}

	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
		req.setAttribute("loginPage", "login/login.jsp");
	}

	public void deleteAcount(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			int galleryBoardCount = ss.getMapper(GalleryMapper.class).countUserGalleryBoard(m);
			if (ss.getMapper(MgzMapper.class).deleteAcount(m) == 1) {
				String path = req.getSession().getServletContext().getRealPath("resources/profilePhoto");
				String Photo = URLDecoder.decode(m.getM_photo(), "utf-8");
				new File(path + "/" + Photo).delete();
				System.out.println(galleryBoardCount);
				gDAO.galleryDiscount(galleryBoardCount);
				req.getSession().setAttribute("loginMember", null);
				req.setAttribute("result", "탈퇴 성공, 이용해주셔서 감사합니다.");
			} else {
				req.setAttribute("result", "탈퇴 실패, 재시도 부탁드립니다.");
			}
		} catch (Exception e) {
			req.setAttribute("result", "탈퇴 실패, 재시도 부탁드립니다.");
			e.printStackTrace();
		}
	}

	public void splitAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String[] addr2 = m.getM_addr().split("!");
		String addr = addr2[0] + " " + addr2[1] + " " + addr2[2];
		req.setAttribute("addr", addr);
		req.setAttribute("addr1", addr2[0]);
		req.setAttribute("addr2", addr2[1]);
		req.setAttribute("addr3", addr2[2]);
	}

	public void updateMyInfo(HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/profilePhoto");
		MultipartRequest mr = null;

		try {
			mr = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("result", "파일 업로드 실패[파일 용량 문제]");
			e.printStackTrace();
		}
		// 여기까지 넘어왔다는 것은
		// 새로운 파일 업로드를 함.
		// 아예 사진 업로드를 안 함.
		Member m2 = (Member) req.getSession().getAttribute("loginMember");
		String oldPhoto = m2.getM_photo();
		String newPhoto = null;
		try {

			String id = mr.getParameter("m_id");
			String nickname = mr.getParameter("m_nickname");

			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr = addr1 + "!" + addr2 + "!" + addr3;

			String pw = mr.getParameter("m_pw");

			newPhoto = mr.getFilesystemName("m_photo");
			if (newPhoto == null) {
				newPhoto = oldPhoto;
			} else {
				newPhoto = URLEncoder.encode(newPhoto, "utf-8").replace("+", " ");
			}

			Member m = new Member(newPhoto, id, pw, nickname, null, null, addr);

			if (ss.getMapper(MgzMapper.class).updateMyInfo(m) == 1) {
				req.setAttribute("result", "정보변경 성공");
				if(!newPhoto.equals(oldPhoto)) {
					oldPhoto = URLDecoder.decode(oldPhoto, "utf-8");
					new File(path + "/" + oldPhoto).delete();
				}
				m2 = ss.getMapper(MgzMapper.class).getMemberByID(m2);
				req.getSession().setAttribute("loginMember", m2);
				System.out.println(m2.getM_photo());
				
			} else {
				req.setAttribute("result", "정보변경 실패");
				new File(path + "/" + mr.getParameter("m_photo")).delete();
			}

		} catch (Exception e) {
			req.setAttribute("result", "파일 업로드 실패[DB 문제]");
			new File(path + "/" + mr.getParameter("m_photo")).delete();
			e.printStackTrace();
		}
	}
	public Members getMemberList(Member m) {
		List<Member> ms = ss.getMapper(MgzMapper.class).getMemberByIDList(m);
		return new Members(ms);
	}
	
}
