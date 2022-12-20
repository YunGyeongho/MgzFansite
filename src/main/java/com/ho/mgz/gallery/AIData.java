package com.ho.mgz.gallery;

import java.math.BigDecimal;

public class AIData {
	private BigDecimal a_hour;
	private BigDecimal a_temp;
	private BigDecimal a_humidity;
	private String a_weather;
	private String a_color;
	
	public AIData() {
		// TODO Auto-generated constructor stub
	}

	public AIData(BigDecimal a_hour, BigDecimal a_temp, BigDecimal a_humidity, String a_weather, String a_color) {
		super();
		this.a_hour = a_hour;
		this.a_temp = a_temp;
		this.a_humidity = a_humidity;
		this.a_weather = a_weather;
		this.a_color = a_color;
	}

	public BigDecimal getA_hour() {
		return a_hour;
	}

	public void setA_hour(BigDecimal a_hour) {
		this.a_hour = a_hour;
	}

	public BigDecimal getA_temp() {
		return a_temp;
	}

	public void setA_temp(BigDecimal a_temp) {
		this.a_temp = a_temp;
	}

	public BigDecimal getA_humidity() {
		return a_humidity;
	}

	public void setA_humidity(BigDecimal a_humidity) {
		this.a_humidity = a_humidity;
	}

	public String getA_weather() {
		return a_weather;
	}

	public void setA_weather(String a_weather) {
		this.a_weather = a_weather;
	}

	public String getA_color() {
		return a_color;
	}

	public void setA_color(String a_color) {
		this.a_color = a_color;
	}
	
}
