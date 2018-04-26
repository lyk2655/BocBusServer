package com.bocbus.project.bean;

import java.util.List;

public class BC0004RspBody {
	private List<StationLocation> stationList;

	public List<StationLocation> getStationList() {
		return stationList;
	}

	public void setStationList(List<StationLocation> stationList) {
		this.stationList = stationList;
	}

	@Override
	public String toString() {
		return "BC0004RspBody [stationList=" + stationList + "]";
	}
	
}
