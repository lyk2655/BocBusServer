<<<<<<< HEAD
package com.bocbus.project.bean;

/**
 * @author wky2527
 *
 * ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½appï¿½Ä·ï¿½ï¿½Ø±ï¿½ï¿½ï¿½Í·
 */

public class BCRspHeader {
	private String RTNSTS; //ï¿½ï¿½ï¿½
	private String ERRMSG; //ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	
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
=======
package com.bocbus.project.bean;

/**
 * @author wky2527
 *
 * ·þÎñÆ÷¸øappµÄ·µ»Ø±¨ÎÄÍ·
 */

public class BCRspHeader {
	private String RTNSTS; //½á¹û
	private String ERRMSG; //´íÎóÃèÊö
	
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
>>>>>>> 9e0237e152cfaf5624a29824318048e21903ee4b
