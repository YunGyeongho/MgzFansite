package com.ho.mgz.gallery;

import java.math.BigDecimal;
import java.util.Date;

public class GalleryWriting {
	private BigDecimal ms_no;
	private String ms_writer;
	private String ms_title;
	private String ms_txt;
	private Date ms_date;
	private String ms_color;
	private String m_photo;

	public GalleryWriting() {
		// TODO Auto-generated constructor stub
	}

	public GalleryWriting(BigDecimal ms_no, String ms_writer, String ms_title, String ms_txt, Date ms_date,
			String ms_color, String m_photo) {
		super();
		this.ms_no = ms_no;
		this.ms_writer = ms_writer;
		this.ms_title = ms_title;
		this.ms_txt = ms_txt;
		this.ms_date = ms_date;
		this.ms_color = ms_color;
		this.m_photo = m_photo;
	}

	public BigDecimal getMs_no() {
		return ms_no;
	}

	public void setMs_no(BigDecimal ms_no) {
		this.ms_no = ms_no;
	}

	public String getMs_writer() {
		return ms_writer;
	}

	public void setMs_writer(String ms_writer) {
		this.ms_writer = ms_writer;
	}

	public String getMs_title() {
		return ms_title;
	}

	public void setMs_title(String ms_title) {
		this.ms_title = ms_title;
	}

	public String getMs_txt() {
		return ms_txt;
	}

	public void setMs_txt(String ms_txt) {
		this.ms_txt = ms_txt;
	}

	public Date getMs_date() {
		return ms_date;
	}

	public void setMs_date(Date ms_date) {
		this.ms_date = ms_date;
	}

	public String getMs_color() {
		return ms_color;
	}

	public void setMs_color(String ms_color) {
		this.ms_color = ms_color;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}
	
}
