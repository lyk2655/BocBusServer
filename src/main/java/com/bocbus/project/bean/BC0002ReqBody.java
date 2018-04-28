package com.bocbus.project.bean;

//获取班车位置
public class BC0002ReqBody {
	private String line; //班车线路
	private String stanum; //0-去公司  1-从公司返回
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getStanum() {
		return stanum;
	}
	public void setStanum(String stanum) {
		this.stanum = stanum;
	}
	@Override
	public String toString() {
		return "BC0002ReqBody [line=" + line + ", stanum=" + stanum + "]";
	}



}
