package com.ho.mgz;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateManager {
	
	public static void getCurYear(HttpServletRequest req) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String curYear2 = sdf.format(now);
		int curYear = Integer.parseInt(curYear2);
		req.setAttribute("curYear", curYear);
	}
}
