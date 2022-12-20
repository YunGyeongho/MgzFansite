package com.ho.mgz.dataroom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ho.mgz.gallery.TokenGenerator;
import com.ho.mgz.login.LoginDAO;

@Controller
public class DataroomController {
	
	@Autowired
	private LoginDAO lDAO;
	
	@Autowired
	private DataroomDAO dDAO;
	
	@RequestMapping(value="/dataroomMain", method=RequestMethod.GET)
	public String goDataRoom(DataroomDate dd, HttpServletRequest req) {
		lDAO.loginCheck(req);
		TokenGenerator.generate(req);
		dDAO.getDataroom(dd, req);
		req.setAttribute("contentPage", "dataroom/dataroomMain.jsp");
		return "index";
	}
	
	
	@RequestMapping(value="/uploadData", method=RequestMethod.POST)
	public String uploadData(DataroomDate dd, HttpServletRequest req) {
		if(lDAO.loginCheck(req)) {
			dDAO.uploadData(dd, req);
			TokenGenerator.generate(req);
			dDAO.getDataroom(dd, req);
		} else {
			req.setAttribute("result", "로그인 후 이용해주세요.");
		}
		req.setAttribute("contentPage", "dataroom/dataroomMain.jsp");
		return "index";
	}
	
	@RequestMapping(value="/dataroom.download", method=RequestMethod.GET)
	public String dataDownload(DataroomDate dd, HttpServletRequest req, HttpServletResponse res) {
		if(lDAO.loginCheck(req)) {
			dDAO.dataDownload(dd, req, res);
			TokenGenerator.generate(req);
			dDAO.getDataroom(dd, req);
		} else {
			req.setAttribute("result", "로그인 후 이용해주세요.");
		}
		req.setAttribute("contentPage", "dataroom/dataroomMain.jsp");
		return "index";
	}
	
	@RequestMapping(value="/dataroom.delete", method=RequestMethod.GET)
	public String deleteFile(DataroomDate dd, HttpServletRequest req) {
		if(lDAO.loginCheck(req)) {
			dDAO.deleteFile(dd, req);
			TokenGenerator.generate(req);
			dDAO.getDataroom(dd, req);
		} else {
			req.setAttribute("result", "로그인 후 이용해주세요.");
		}
		req.setAttribute("contentPage", "dataroom/dataroomMain.jsp");
		return "index";
	}
}
