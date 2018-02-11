package com.bocbus.project.bean;

/**
 * @author wky2527
 *
 * AP上送报文头
 */

public class BCReqHeader {
	private String TRACDE; //前端交易码
	private String TRADAT; //交易日期
	private String TRATIM; //交易时间
	private String USRNAM;
	
	public String getTRACDE() {
		return TRACDE;
	}
	public void setTRACDE(String tRACDE) {
		TRACDE = tRACDE;
	}
	public String getTRADAT() {
		return TRADAT;
	}
	public void setTRADAT(String tRADAT) {
		TRADAT = tRADAT;
	}
	public String getTRATIM() {
		return TRATIM;
	}
	public void setTRATIM(String tRATIM) {
		TRATIM = tRATIM;
	}
	public String getUSRNAM() {
		return USRNAM;
	}
	public void setUSRNAM(String uSRNAM) {
		USRNAM = uSRNAM;
	}
	

}
