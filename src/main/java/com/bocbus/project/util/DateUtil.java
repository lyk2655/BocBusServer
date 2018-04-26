package com.bocbus.project.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private String dt;
	private String tm;
	
	public DateUtil(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSSSS");
		String daytime = df.format(new Date());
		
		this.dt = daytime.substring(0,8);
		this.tm = daytime.substring(8, 19);
	}
	
	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getTm() {
		return tm;
	}

	public void setTm(String tm) {
		this.tm = tm;
	}

	@Override
	public String toString() {
		return "DateUtil [dt=" + dt + ", tm=" + tm + "]";
	}
	

}
