package com.bocbus.project.bean;

public class BC0003Req {
	private BCReqHeader head;
	private BC0003ReqBody body;
	public BCReqHeader getHead(){
		return head;
	}
	public void setHead(BCReqHeader head){
		this.head = head;
	}
	public BC0003ReqBody getBody(){
		return this.body;
	}
	public void setBody(BC0003ReqBody body){
		this.body = body;
	}
}
