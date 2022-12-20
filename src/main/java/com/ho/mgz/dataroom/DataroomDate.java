package com.ho.mgz.dataroom;

import java.math.BigDecimal;
import java.util.Date;

public class DataroomDate {
	private BigDecimal md_no;
	private String md_uploader;
	private String md_title;
	private String md_category;
	private String md_file;
	private String md_fileName;
	private Date md_date;
	
	public DataroomDate() {
		// TODO Auto-generated constructor stub
	}

	public DataroomDate(BigDecimal md_no, String md_uploader, String md_title, String md_category, String md_file,
			String md_fileName, Date md_date) {
		super();
		this.md_no = md_no;
		this.md_uploader = md_uploader;
		this.md_title = md_title;
		this.md_category = md_category;
		this.md_file = md_file;
		this.md_fileName = md_fileName;
		this.md_date = md_date;
	}

	public BigDecimal getMd_no() {
		return md_no;
	}

	public void setMd_no(BigDecimal md_no) {
		this.md_no = md_no;
	}

	public String getMd_uploader() {
		return md_uploader;
	}

	public void setMd_uploader(String md_uploader) {
		this.md_uploader = md_uploader;
	}

	public String getMd_title() {
		return md_title;
	}

	public void setMd_title(String md_title) {
		this.md_title = md_title;
	}

	public String getMd_category() {
		return md_category;
	}

	public void setMd_category(String md_category) {
		this.md_category = md_category;
	}

	public String getMd_file() {
		return md_file;
	}

	public void setMd_file(String md_file) {
		this.md_file = md_file;
	}

	public String getMd_fileName() {
		return md_fileName;
	}

	public void setMd_fileName(String md_fileName) {
		this.md_fileName = md_fileName;
	}

	public Date getMd_date() {
		return md_date;
	}

	public void setMd_date(Date md_date) {
		this.md_date = md_date;
	}

	
	
}
