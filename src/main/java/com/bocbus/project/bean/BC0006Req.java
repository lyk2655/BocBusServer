package com.bocbus.project.bean;

public class BC0006Req {
	private BCReqHeader head; 
	private BC0006ReqBody body;
	public BCReqHeader getHead() {
		return head;
	}
	public void setHead(BCReqHeader head) {
		this.head = head;
	}
	public BC0006ReqBody getBody() {
		return body;
	}
	public void setBody(BC0006ReqBody body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "BC0006Req [head=" + head + ", body=" + body + "]";
	}
	
}
