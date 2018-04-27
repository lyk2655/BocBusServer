package com.bocbus.project.bean;

public class BC0005ReqBody {
	//查询班车位置
	private String line;
	private String longitude;
	private String latitude;
	private String toc;
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getToc() {
		return toc;
	}
	public void setToc(String toc) {
		this.toc = toc;
	}
	@Override
	public String toString() {
		return "BC0005ReqBody [line=" + line + ", longitude=" + longitude + ", latitude=" + latitude + ", toc=" + toc
				+ "]";
	}
	
	
	
}
