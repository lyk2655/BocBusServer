package com.bocbus.project.bean;

public class BC0002Rsp {
	private BCRspHeader head; //报文头
	private BC0002RspBody body; //报文体

	public BC0002RspBody getBody() {
		return body;
	}
	public void setBody(BC0002RspBody body) {
		this.body = body;
	}
	public BCRspHeader getHead() {
		return head;
	}
	public void setHead(BCRspHeader head) {
		this.head = head;
	}

}
