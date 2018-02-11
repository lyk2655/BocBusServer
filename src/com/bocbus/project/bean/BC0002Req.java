package com.bocbus.project.bean;

public class BC0002Req {
	private BCReqHeader head; //报文头
	private BC0002ReqBody body; //报文体
	public BCReqHeader getHead() {
		return head;
	}
	public void setHead(BCReqHeader head) {
		this.head = head;
	}
	public BC0002ReqBody getBody() {
		return body;
	}
	public void setBody(BC0002ReqBody body) {
		this.body = body;
	}

}
