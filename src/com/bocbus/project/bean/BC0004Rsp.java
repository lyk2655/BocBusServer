package com.bocbus.project.bean;

public class BC0004Rsp {
	private BCRspHeader head; 
	private BC0004RspBody body;
	public BCRspHeader getHead() {
		return head;
	}
	public void setHead(BCRspHeader head) {
		this.head = head;
	}
	public BC0004RspBody getBody() {
		return body;
	}
	public void setBody(BC0004RspBody body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "BC0004Rsp [head=" + head + ", body=" + body + "]";
	} 
}
