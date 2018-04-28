package com.bocbus.project.bean;

public class BC0006ReqBody {
	private String line;
	private String longitude;
	private String latitude;
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
	@Override
	public String toString() {
		return "BC0005RspBody [line=" + line + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
}
