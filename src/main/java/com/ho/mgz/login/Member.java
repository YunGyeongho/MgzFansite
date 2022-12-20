package com.ho.mgz.login;

import java.util.Date;

public class Member {
	private String m_photo;
	private String m_id;
	private String m_pw;
	private String m_nickname;
	private Date m_birthday;
	private String m_block;
	private String m_addr;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String m_photo, String m_id, String m_pw, String m_nickname, Date m_birthday, String m_block,
			String m_addr) {
		super();
		this.m_photo = m_photo;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_nickname = m_nickname;
		this.m_birthday = m_birthday;
		this.m_block = m_block;
		this.m_addr = m_addr;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_nickname() {
		return m_nickname;
	}

	public void setM_nickname(String m_nickname) {
		this.m_nickname = m_nickname;
	}

	public Date getM_birthday() {
		return m_birthday;
	}

	public void setM_birthday(Date m_birthday) {
		this.m_birthday = m_birthday;
	}

	public String getM_block() {
		return m_block;
	}

	public void setM_block(String m_block) {
		this.m_block = m_block;
	}

	public String getM_addr() {
		return m_addr;
	}

	public void setM_addr(String m_addr) {
		this.m_addr = m_addr;
	}
	
	
}
