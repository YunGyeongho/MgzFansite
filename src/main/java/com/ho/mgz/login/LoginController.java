package com.ho.mgz.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ho.mgz.DateManager;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDAO lDAO;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String goJoin(HttpServletRequest req){
		DateManager.getCurYear(req);
		lDAO.getLatestBlock(req);
		return "login/join";
	}
	
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public String welcomeJoin(HttpServletRequest req) {
		lDAO.join(req);
		req.setAttribute("loginPage", "login/login.jsp");
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String welcomeLogin(Member m, HttpServletRequest req) {
		lDAO.login(m, req);
		lDAO.loginCheck(req);
		return "index";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		lDAO.logout(req);
		return "index";
	}
	
	@RequestMapping(value="/myInfo", method=RequestMethod.GET)
	public String goMyInfo(HttpServletRequest req) {
		if(lDAO.loginCheck(req)) {
			lDAO.splitAddr(req);
			req.setAttribute("loginPage", "login/myInfo.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value="/closeMyInfo", method=RequestMethod.GET)
	public String closeMyInfo(HttpServletRequest req) {
		lDAO.loginCheck(req);
		return "index";
	}
	
	@RequestMapping(value="/deleteAcount", method=RequestMethod.GET)
	public String deleteAcount(HttpServletRequest req) {
		lDAO.deleteAcount(req);
		lDAO.loginCheck(req);
		return "index";
	}
	
	@RequestMapping(value="/goUpdateMyInfo", method=RequestMethod.GET)
	public String goUpdateMyInfo(HttpServletRequest req) {
		if(lDAO.loginCheck(req)) {
			lDAO.splitAddr(req);
			req.setAttribute("loginPage", "login/updateMyInfo.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value="/updateMyInfo", method=RequestMethod.POST)
	public String updateMyInfo(Member m, HttpServletRequest req) {
		lDAO.updateMyInfo(req);
		lDAO.splitAddr(req);
		req.setAttribute("loginPage", "login/myInfo.jsp");
		return "index";
	}
	
	@RequestMapping(value="/getMembers", method=RequestMethod.GET,
			produces="application/json; charset=utf-8")
	public @ResponseBody Members getMembers(Member m) {
		
		return lDAO.getMemberList(m);
	}
}
