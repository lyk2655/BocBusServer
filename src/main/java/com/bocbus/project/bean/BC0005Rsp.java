package com.bocbus.project.bean;

public class BC0005Rsp {
	private BCRspHeader head; 
	private BUS_BUS body;
	public BCRspHeader getHead() {
		return head;
	}
	public void setHead(BCRspHeader head) {
		this.head = head;
	}
	public BUS_BUS getBody() {
		return body;
	}
	public void setBody(BUS_BUS body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "BC0005Rsp [head=" + head + ", body=" + body + "]";
	}


}
