package com.bocbus.project.bean;

public class BC0006Rsp {
	private BCReqHeader head; 
	private BUS_LINE line;
	public BCReqHeader getHead() {
		return head;
	}
	public void setHead(BCReqHeader head) {
		this.head = head;
	}
	public BUS_LINE getLine() {
		return line;
	}
	public void setLine(BUS_LINE line) {
		this.line = line;
	}
	@Override
	public String toString() {
		return "BC0005RspBody [head=" + head + ", line=" + line + "]";
	}
}
