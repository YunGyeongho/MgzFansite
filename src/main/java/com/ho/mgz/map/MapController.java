package com.ho.mgz.map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ho.mgz.login.LoginDAO;

@Controller
public class MapController {

	@Autowired
	private LoginDAO lDAO;
		
	@RequestMapping(value="mapMain", method=RequestMethod.GET)
	public String goMap(HttpServletRequest req) {
		lDAO.loginCheck(req);
		req.setAttribute("contentPage", "map/map.jsp");
		return "index";
	}
}
