package com.bocbus.project.bean;

public class BC0005Req {
	private BCReqHeader head; //����ͷ
	private BC0005ReqBody body; //������
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
	@Override
	public String toString() {
		return "BC0005Req [head=" + head + ", body=" + body + "]";
	}
}
