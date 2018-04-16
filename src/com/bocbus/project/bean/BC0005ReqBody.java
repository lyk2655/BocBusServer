<<<<<<< HEAD
package com.bocbus.project.bean;

public class BC0005ReqBody {
	private String line;
	private String longitude;
	private String latitude;
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
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
		return "BC0005ReqBody [line=" + line + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}


	
}
=======
package com.bocbus.project.bean;

public class BC0005ReqBody {
	private String LINE;// 班车路线
	private String LONGITUDE;	//经度
	private String LATITUDE;    //纬度

	public String getLINE() {
		return LINE;
	}

	public void setLINE(String line) {
		LINE = line;
	}
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

	
}
>>>>>>> 9e0237e152cfaf5624a29824318048e21903ee4b
