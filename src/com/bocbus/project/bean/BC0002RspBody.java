package com.bocbus.project.bean;

public class BC0002RspBody {
	private String LONGITUDE;	//����
	
	private String LATITUDE;    //γ��

	public String getLONGITUDE() {
		return LONGITUDE;
	}

	public void setLONGITUDE(String longitude) {
		LONGITUDE = longitude;
	}

	public String getLATITUDE() {
		return LATITUDE;
	}

	public void setLATITUDE(String latitude) {
		LATITUDE = latitude;
	}

	@Override
	public String toString() {
		return "BC0002RspBody [LONGITUDE=" + LONGITUDE + ", LATITUDE=" + LATITUDE + "]";
	}

	
}
