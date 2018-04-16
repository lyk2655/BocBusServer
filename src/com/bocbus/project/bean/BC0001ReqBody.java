package com.bocbus.project.bean;

public class BC0001ReqBody {
	private String line;
	private String mode;
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	@Override
	public String toString() {
		return "BC0001ReqBody [line=" + line + ", mode=" + mode + "]";
	}
	
}
