package com.bocbus.project.bean;

public class StationLocation {
	private String stationNo;
	private String longitude;
	private String latitude;
	public String getStationNo() {
		return stationNo;
	}
	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
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
		return "StationLocation [stationNo=" + stationNo + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	
}
