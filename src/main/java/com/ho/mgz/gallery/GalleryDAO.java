package com.ho.mgz.gallery;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ho.mgz.BoardPerPage;
import com.ho.mgz.login.Member;

@Service
public class GalleryDAO {
	
	private int galleryBoardCount;
	//private URL u;
	
	@Autowired
	private BoardPerPage bp;
	
	@Autowired
	private SqlSession ss;
	
	public GalleryDAO() {
	}
	
	public void galleryDiscount(int discount) {
		galleryBoardCount -= discount;
	}
	
	public void setGalleryBoardCount(SearchOption so) {
		galleryBoardCount = ss.getMapper(GalleryMapper.class).setGalleryBoardCount(so);
		System.out.println(galleryBoardCount);
	}
	
	public void setMsColor(HttpServletRequest req) {
		
		HttpURLConnection huc = null;
		try {
			URL u = new URL("http://192.168.0.158:7887/color.get");
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(isr);
			String color = jo.get("color").toString();
			req.setAttribute("boardColor", color);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
	
	public void write(GalleryWriting gw, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			if(successToken != null && token.equals(successToken)) {
				return;
			}
			Member m = (Member) req.getSession().getAttribute("loginMember");
			gw.setMs_writer(m.getM_id());
			gw.setMs_txt(req.getParameter("ms_txt").replace("\r\n", "<br>"));
			
			if(ss.getMapper(GalleryMapper.class).writeGallery(gw) == 1) {
				req.setAttribute("result", "글 쓰기 성공");
				galleryBoardCount ++;
				req.getSession().setAttribute("successToken", token);
			} else {
				req.setAttribute("result", "글 쓰기 실패");
			}
		} catch (Exception e) {
			req.setAttribute("result", "글 쓰기 실패");
			e.printStackTrace();
		}
	}
	
	public void regAIDate(GalleryWriting gw, HttpServletRequest req) {
		HttpsURLConnection huc = null;
		try {
			URL u = new URL("https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr");
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(isr);
			JSONArray weather = (JSONArray) jo.get("weather");
			JSONObject weather0 = (JSONObject) weather.get(0);
			String description = (String) weather0.get("description");
			JSONObject main = (JSONObject) jo.get("main");
			BigDecimal temp = new BigDecimal(main.get("temp").toString());
			BigDecimal humidity = new BigDecimal(main.get("humidity").toString());
			String hour = new SimpleDateFormat("HH").format(new Date());
			
			AIData ad = new AIData(new BigDecimal(hour), temp, humidity, description, gw.getMs_color());
			ss.getMapper(GalleryMapper.class).regAIData(ad);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
	
	public void getGallery(int page, HttpServletRequest req) {
		try {
			int galleryPerPage = bp.getGalleryPerPage();
			int start = (page - 1) * galleryPerPage + 1;
			int end = page * galleryPerPage;
			int galleryCount = galleryBoardCount;
			SearchOption so = new SearchOption(new BigDecimal(start), new BigDecimal(end), "");
			String search = (String) req.getSession().getAttribute("search");
			
			if(search != null) {
				so.setSearch(search);
				galleryCount = ss.getMapper(GalleryMapper.class).setGalleryBoardCount(so);
			}
			
			int pageCount = (int) Math.ceil(galleryCount / (double) galleryPerPage);
			req.setAttribute("pageCount", pageCount);
			
			List<GalleryWriting> gw = ss.getMapper(GalleryMapper.class).getGallery(so);
			req.setAttribute("GalleryInfo", gw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showUpdateGallery(HttpServletRequest req) {
		try {
			int no = Integer.parseInt(req.getParameter("no"));
			GalleryWriting gw = ss.getMapper(GalleryMapper.class).showUpdateGallery(new GalleryWriting(new BigDecimal(no), null, null, null, null, null, null));
			req.setAttribute("uGInfo", gw);
			req.setAttribute("reWrite", "(수정됨)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateGallery(GalleryWriting gw, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			if(successToken != null && token.equals(successToken)) {
				return;
			}
			
			gw.setMs_title(gw.getMs_title() + " " +req.getParameter("reWrite"));
			gw.setMs_txt(gw.getMs_txt().replace("\r\n", "<br>"));
			gw.setMs_no(new BigDecimal(req.getParameter("no")));
			
			if(ss.getMapper(GalleryMapper.class).updateGallery(gw) == 1) {
				req.setAttribute("result", "수정 성공");
				req.getSession().setAttribute("successToken", token);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정 실패");
		}
	}
	
	public void deleteGallery(GalleryWriting gw, HttpServletRequest req) {
		try {
			gw.setMs_no(new BigDecimal(req.getParameter("no")));
			if(ss.getMapper(GalleryMapper.class).deleteGallery(gw) == 1) {
				req.setAttribute("result", "삭제 성공");
				galleryBoardCount--;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "삭제 실패");
		}
	}
	
	public void writeReply(GalleryReply gr, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			if(successToken != null && token.equals(successToken)) {
				return;
			}
			Member m = (Member) req.getSession().getAttribute("loginMember");
			gr.setMsr_m_photo(m.getM_photo());
			gr.setMsr_writer(m.getM_id());
			gr.setMsr_txt(gr.getMsr_txt().replace("\r\n", "<br>"));
			if(ss.getMapper(GalleryMapper.class).writeGReply(gr) == 1) {
				req.setAttribute("result", "댓글작성 성공");
				req.getSession().setAttribute("successToken", token);
			} else {
				req.setAttribute("result", "댓글작성 실패");
			}
		} catch (Exception e) {
			req.setAttribute("result", "댓글작성 실패");
			e.printStackTrace();
		}
	}
	
	public void showGReply(GalleryReply gr, HttpServletRequest req) {
		try {
			gr.setMsr_ms_no(new BigDecimal(req.getParameter("no")));
			
			List<GalleryReply> gr2 = ss.getMapper(GalleryMapper.class).showGReply(gr);
			req.setAttribute("gReply", gr2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}	
