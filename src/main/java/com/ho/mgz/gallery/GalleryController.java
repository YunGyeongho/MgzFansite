package com.ho.mgz.gallery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ho.mgz.SearchManager;
import com.ho.mgz.login.LoginDAO;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryDAO gDAO;
	
	@Autowired
	private LoginDAO lDAO;
	
	@RequestMapping(value="/galleryMain", method=RequestMethod.GET)
	public String goGallery(HttpServletRequest req, @RequestParam(value="page") int p) {
		SearchManager.searchClear(req);
		lDAO.loginCheck(req);
		TokenGenerator.generate(req);
		gDAO.setMsColor(req);
		SearchManager.search(req);
		gDAO.getGallery(p, req);
		req.setAttribute("contentPage", "gallery/galleryMain.jsp");
		return "index";
	}
	
	@RequestMapping(value="/galleryWrite", method=RequestMethod.POST)
	public String writeGallery(GalleryWriting gw, HttpServletRequest req) {
		if(lDAO.loginCheck(req)) {
			gDAO.write(gw, req);
			TokenGenerator.generate(req);
			gDAO.setMsColor(req);
			gDAO.getGallery(1, req);
			req.setAttribute("contentPage", "gallery/galleryMain.jsp");
		} else {
			req.setAttribute("result", "로그인 후 이용해주세요.");
		}
		return "index";
	}
	
	@RequestMapping(value="/showUpdateGalleryInfo", method=RequestMethod.GET)
	public String showUpdateGalleryInfo(HttpServletRequest req, @RequestParam(value="page") int p) {
		if(lDAO.loginCheck(req)) {
			gDAO.showUpdateGallery(req);
			TokenGenerator.generate(req);
			gDAO.setMsColor(req);
			gDAO.getGallery(p, req);
			req.setAttribute("contentPage", "gallery/galleryMain.jsp");
		} else {
			req.setAttribute("result", "로그인 후 이용해주세요.");
		}
		return "index";
	}
	
	@RequestMapping(value="/updateGallery", method=RequestMethod.POST)
	public String updateGallery(GalleryWriting gw, HttpServletRequest req, @RequestParam(value="page") int p) {
		if(lDAO.loginCheck(req)) {
			gDAO.updateGallery(gw, req);
			TokenGenerator.generate(req);
			gDAO.setMsColor(req);
			gDAO.getGallery(p, req);
			req.setAttribute("contentPage", "gallery/galleryMain.jsp");
		} else {
			req.setAttribute("result", "로그인 후 이용해주세요.");
		}
		return "index";
	}
	
	@RequestMapping(value="/galleryDelete", method=RequestMethod.GET)
	public String deleteGallery(GalleryWriting gw, HttpServletRequest req, @RequestParam(value="page") int p) {
		if(lDAO.loginCheck(req)) {
			gDAO.deleteGallery(gw, req);
			TokenGenerator.generate(req);
			gDAO.setMsColor(req);
			gDAO.getGallery(p, req);
			req.setAttribute("contentPage", "gallery/galleryMain.jsp");
		} else {
			req.setAttribute("result", "로그인 후 이용해주세요.");
		}
		
		return "index";
	}
	
	@RequestMapping(value="/writeGalleryReply", method=RequestMethod.POST)
	public String writeGalleryReply(GalleryReply gr , HttpServletRequest req, @RequestParam(value="page") int p) {
		if(lDAO.loginCheck(req)) {
			gDAO.writeReply(gr, req);
			TokenGenerator.generate(req);
			gDAO.setMsColor(req);
			gDAO.getGallery(p, req);
			req.setAttribute("contentPage", "gallery/galleryMain.jsp");
		} else {
			req.setAttribute("result", "로그인 후 이용해주세요.");
		}
		return "index";
	}
	
	@RequestMapping(value="/showGalleryReply", method=RequestMethod.GET)
	public String showGalleryReply(GalleryReply gr , HttpServletRequest req, @RequestParam(value="page") int p) {
		lDAO.loginCheck(req);
		
		TokenGenerator.generate(req);
		gDAO.setMsColor(req);
		gDAO.getGallery(p, req);
		req.setAttribute("contentPage", "gallery/galleryMain.jsp");
		
		return "index";
	}
	
}
