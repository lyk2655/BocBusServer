<<<<<<< HEAD
package com.bocbus.project.bean;


public class BCReqHeader {
	private String TRACDE; //前端交易码
	private String TRADAT; //交易日期
	private String TRATIM; //交易时间
	private String USRNAM; //登陆用户名
	
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
	@Override
	public String toString() {
		return "BCReqHeader [TRACDE=" + TRACDE + ", TRADAT=" + TRADAT + ", TRATIM=" + TRATIM + ", USRNAM=" + USRNAM
				+ "]";
	}
	

}
=======
package com.bocbus.project.bean;

/**
 * @author wky2527
 *
 * AP���ͱ���ͷ
 */

public class BCReqHeader {
	private String TRACDE; //ǰ�˽�����
	private String TRADAT; //��������
	private String TRATIM; //����ʱ��
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
>>>>>>> 9e0237e152cfaf5624a29824318048e21903ee4b
