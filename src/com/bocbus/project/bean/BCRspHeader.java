package com.bocbus.project.bean;

/**
 * @author wky2527
 *
 * 服务器给app的返回报文头
 */

public class BCRspHeader {
	private String RTNSTS; //结果
	private String ERRMSG; //错误描述
	
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
}
