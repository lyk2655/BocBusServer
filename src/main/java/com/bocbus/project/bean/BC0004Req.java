package com.bocbus.project.bean;

public class BC0004Req {

	private BCReqHeader head; 
	private BC0004ReqBody body;
	public BCReqHeader getHead() {
		return head;
	}
	public void setHead(BCReqHeader head) {
		this.head = head;
	}
	public BC0004ReqBody getBody() {
		return body;
	}
	public void setBody(BC0004ReqBody body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "BC0004Req [head=" + head + ", body=" + body + "]";
	}
	
}
