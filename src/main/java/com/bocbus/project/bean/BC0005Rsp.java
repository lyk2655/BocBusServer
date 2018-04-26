package com.bocbus.project.bean;

public class BC0005Rsp {
	private BCRspHeader head; 
	private BC0005RspBody body;

	public BC0005RspBody getBody() {
		return body;
	}
	public void setBody(BC0005RspBody body) {
		this.body = body;
	}
	public BCRspHeader getHead() {
		return head;
	}
	public void setHead(BCRspHeader head) {
		this.head = head;
	}
}
