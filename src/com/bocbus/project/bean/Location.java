package com.bocbus.project.bean;
/**
 * @author wxh2525
 *
 * 交易流水表记录
 */
public class Location {

	private String Line;
	private String Longitude;
	private String Latitude;
	
	public String getLine() {
		return Line;
	}
	public void setLine(String line) {
		Line = line;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public String getLatitude() {
		return Latitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
}