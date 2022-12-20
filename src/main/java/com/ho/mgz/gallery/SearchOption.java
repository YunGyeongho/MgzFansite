package com.ho.mgz.gallery;

import java.math.BigDecimal;

public class SearchOption {
	private BigDecimal start;
	private BigDecimal end;
	private String search;
	
	public SearchOption() {
		// TODO Auto-generated constructor stub
	}

	public SearchOption(BigDecimal start, BigDecimal end, String search) {
		super();
		this.start = start;
		this.end = end;
		this.search = search;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	
	
}
