package com.bocbus.project.bean;

public class BC0002Rsp {
	private BCRspHeader head; //����ͷ
	private BC0002RspBody body; //������

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
	@Override
	public String toString() {
		return "BC0002Rsp [head=" + head + ", body=" + body + "]";
	}

}
