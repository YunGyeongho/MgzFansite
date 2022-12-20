package com.ho.mgz;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ho.mgz.gallery.GalleryDAO;
import com.ho.mgz.gallery.SearchOption;
import com.ho.mgz.login.LoginDAO;

@Controller
public class HomeController {
	
	@Autowired
	private LoginDAO lDAO;
	
	@Autowired
	private GalleryDAO gDAO;
	
	private boolean isFirst;
	
	public HomeController() {
		isFirst = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goIndex(HttpServletRequest req) {
		if(isFirst) { 
			gDAO.setGalleryBoardCount(new SearchOption(null, null, ""));
			isFirst = false;
		}
		lDAO.loginCheck(req);
		return "index";
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String goHome(HttpServletRequest req) {
		return goIndex(req);
	}
	
}
