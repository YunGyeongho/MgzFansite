package com.ho.mgz.gallery;

import java.math.BigDecimal;
import java.util.Date;

public class GalleryReply {
	private BigDecimal msr_no;
	private String msr_m_photo;
	private BigDecimal msr_ms_no;
	private String msr_writer;
	private String msr_txt;
	private Date msr_date;
	
	public GalleryReply() {
		// TODO Auto-generated constructor stub
	}

	public GalleryReply(BigDecimal msr_no, String msr_m_photo, BigDecimal msr_ms_no, String msr_writer, String msr_txt,
			Date msr_date) {
		super();
		this.msr_no = msr_no;
		this.msr_m_photo = msr_m_photo;
		this.msr_ms_no = msr_ms_no;
		this.msr_writer = msr_writer;
		this.msr_txt = msr_txt;
		this.msr_date = msr_date;
	}

	public BigDecimal getMsr_no() {
		return msr_no;
	}

	public void setMsr_no(BigDecimal msr_no) {
		this.msr_no = msr_no;
	}

	public String getMsr_m_photo() {
		return msr_m_photo;
	}

	public void setMsr_m_photo(String msr_m_photo) {
		this.msr_m_photo = msr_m_photo;
	}

	public BigDecimal getMsr_ms_no() {
		return msr_ms_no;
	}

	public void setMsr_ms_no(BigDecimal msr_ms_no) {
		this.msr_ms_no = msr_ms_no;
	}

	public String getMsr_writer() {
		return msr_writer;
	}

	public void setMsr_writer(String msr_writer) {
		this.msr_writer = msr_writer;
	}

	public String getMsr_txt() {
		return msr_txt;
	}

	public void setMsr_txt(String msr_txt) {
		this.msr_txt = msr_txt;
	}

	public Date getMsr_date() {
		return msr_date;
	}

	public void setMsr_date(Date msr_date) {
		this.msr_date = msr_date;
	}
	
}
