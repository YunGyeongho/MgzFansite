package com.ho.mgz.dataroom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ho.mgz.login.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class DataroomDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void uploadData(DataroomDate dd, HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/dataroomFile");
		try {
			mr = new MultipartRequest(req, path, 1073741824, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "파일 업로드 실패[파일 용량문제]");
		}
		String realFile = mr.getFilesystemName("md_file");
		try {
			String token = mr.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			if(successToken != null && token.equals(successToken)) {
				new File(path + "/" + realFile).delete();
				req.setAttribute("result", "새로고침 업로드 실패");
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			dd.setMd_uploader(m.getM_id());
			dd.setMd_title(mr.getParameter("md_title"));
			dd.setMd_category(mr.getParameter("md_category"));
			String file = URLEncoder.encode(realFile, "utf-8").replace("+", " ");
			dd.setMd_file(file);
			
			if(ss.getMapper(DataroomMapper.class).uploadData(dd) == 1) {
				req.setAttribute("result", "업로드 성공");
				req.getSession().setAttribute("successToken", token);
			} else {
				req.setAttribute("result", "업로드 실패");
				new File(path + "/" + realFile).delete();
			}
			
		} catch (Exception e) {
			req.setAttribute("result", "DB문제로 실패");
			new File(path + "/" + realFile).delete();
			e.printStackTrace();
		}
	}
	
	public void getDataroom(DataroomDate dd, HttpServletRequest req) {
		try {
			dd.setMd_category("a");
			List<DataroomDate> ddA = ss.getMapper(DataroomMapper.class).showDataroom(dd);
			for (DataroomDate dda : ddA) {
				dda.setMd_fileName(URLDecoder.decode(dda.getMd_file(), "utf-8"));
			}
			
			dd.setMd_category("b");
			List<DataroomDate> ddB = ss.getMapper(DataroomMapper.class).showDataroom(dd);
			for (DataroomDate ddb : ddB) {
				ddb.setMd_fileName(URLDecoder.decode(ddb.getMd_file(), "utf-8"));
			}
			
			dd.setMd_category("c");
			List<DataroomDate> ddC = ss.getMapper(DataroomMapper.class).showDataroom(dd);
			for (DataroomDate ddc : ddC) {
				ddc.setMd_fileName(URLDecoder.decode(ddc.getMd_file(), "utf-8"));
			}
			
			req.setAttribute("ddA", ddA);
			req.setAttribute("ddB", ddB);
			req.setAttribute("ddC", ddC);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void dataDownload(DataroomDate dd, HttpServletRequest req) {
//		ReadableByteChannel rbc = null;
//		FileOutputStream fos = null;
//		try {
//			String file = ss.getMapper(DataroomMapper.class).getFileName(dd);
//			String s = "http://localhost/mgz/resources/dataroomFile/" + file;
//			URL u = new URL(s);
//			
//			//통로 InputStream 같은 빨대 역할
//			rbc = Channels.newChannel(u.openStream());
//			
//			//다운 받을 거 어디에 갖다 놓을지
//			String userFolder = System.getProperty("user.home"); //사용자의 홈 폴더 가져오기
//			userFolder += "\\Downloads\\";
//			//사용자 컴퓨터에 이상한 외계어로 저장할 수 없으니 디코딩을 다시 해줌.
//			file = URLDecoder.decode(file, "utf-8");
//			//C:\Users\사용자명\Downloads\파일명.확장자 이렇게 주겠다라는 말
//			fos = new FileOutputStream(userFolder + file);
//			
//			//0101로 되어있는 데이터를 0번째 부터 max 까지 다 가져오겠다.
//			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
//			
//			req.setAttribute("result", "다운로드 완료");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			req.setAttribute("result", "다운로드 실패");
//		}
//		try {
//			fos.close();
//		} catch (IOException e) {
//		}
//		try {
//			rbc.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void dataDownload(DataroomDate dd, HttpServletRequest req, HttpServletResponse res) {
		FileInputStream fis = null;
		ServletOutputStream sos =null;
		
		try {
			// 파일명 가져와서 decode
			String file = URLDecoder.decode(ss.getMapper(DataroomMapper.class).getFileName(dd), "utf-8");
			// 절대 경로 가져와서 폴더명과 합침
			String path = req.getSession().getServletContext().getRealPath("resources/dataroomFile");
			path += "/" + file;
			
			//응답 객체에 정보 넣어줌
			res.reset();
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attachment; filename=" + file);
			
			fis = new FileInputStream(path); // 대상 파일에서 읽어올 수 있는 빨대
			sos = res.getOutputStream(); // 사용자 파일에 써 줄 빨대
			
			//4096개씩 읽어서 => int에 저장 => 사용자 파일에 쓰기
			byte[] b = new byte[4096];
			int numRead;
			while((numRead = fis.read(b, 0, b.length)) != -1) {
				sos.write(b, 0, numRead);
			}
			sos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			sos.close();
		} catch (IOException e) {
		}
		try {
			fis.close();
		} catch (IOException e) {
		}
	}
	
	public void deleteFile(DataroomDate dd, HttpServletRequest req) {
		try {
			String file = URLDecoder.decode(ss.getMapper(DataroomMapper.class).getFileName(dd), "utf-8");
			
			if(ss.getMapper(DataroomMapper.class).deleteFile(dd) == 1) {
				String path = req.getSession().getServletContext().getRealPath("resources/dataroomFile");
				new File(path + "/" + file).delete();
				req.setAttribute("result", "삭제 완료");
			} else {
				req.setAttribute("result", "삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "삭제 실패");
		}
	}
}
