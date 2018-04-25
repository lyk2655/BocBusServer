package com.bocbus.project.bean;


public class BCRspHeader {
	private String RTNSTS; 
	private String ERRMSG;
	
	public String getRTNSTS() {
		return RTNSTS;
	}
	public void setRTNSTS(String rTNSTS) {
		RTNSTS = rTNSTS;
	}
	public String getERRMSG() {
		return ERRMSG;
	}
	public void setERRMSG(String eRRMSG) {
		ERRMSG = eRRMSG;
	}

	public void setHeader(String rTNSTS,String eRRMSG) {
		RTNSTS = rTNSTS;
		ERRMSG=eRRMSG;
	}
	@Override
	public String toString() {
		return "BCRspHeader [RTNSTS=" + RTNSTS + ", ERRMSG=" + ERRMSG + "]";
	}
	
}
