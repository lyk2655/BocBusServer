package com.bocbus.project.bean;

public class BC0002RspBody {
	
	private String longitude;  //班车经纬度
	private String latitude;   //班车经纬度
	private String lastStation; //上一站点ID
	private String nextStation; //下一站点ID
	private String nextTime;    //到达下一站点预计时间
	private String nextDistance;//到达下一站点预计距离
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
	public String getLastStation() {
		return lastStation;
	}
	public void setLastStation(String lastStation) {
		this.lastStation = lastStation;
	}
	public String getNextStation() {
		return nextStation;
	}
	public void setNextStation(String nextStation) {
		this.nextStation = nextStation;
	}
	public String getNextTime() {
		return nextTime;
	}
	public void setNextTime(String nextTime) {
		this.nextTime = nextTime;
	}
	public String getNextDistance() {
		return nextDistance;
	}
	public void setNextDistance(String nextDistance) {
		this.nextDistance = nextDistance;
	}
	@Override
	public String toString() {
		return "BC0002RspBody [longitude=" + longitude + ", latitude=" + latitude + ", lastStation=" + lastStation
				+ ", nextStation=" + nextStation + ", nextTime=" + nextTime + ", nextDistance=" + nextDistance + "]";
	}
	
}
