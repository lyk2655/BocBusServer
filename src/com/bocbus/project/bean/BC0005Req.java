package com.bocbus.project.bean;

public class BC0005Req {
	private BCReqHeader head; //报文头
	private BC0005ReqBody body; //报文体
	public BCReqHeader getHead() {
		return head;
	}
	public void setHead(BCReqHeader head) {
		this.head = head;
	}
	public BC0005ReqBody getBody() {
		return body;
	}
	public void setBody(BC0005ReqBody body) {
		this.body = body;
	}
}
