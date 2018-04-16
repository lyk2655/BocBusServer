<<<<<<< HEAD
package com.bocbus.project.bean;

public class BC0002Rsp {
	private BCRspHeader head; //ï¿½ï¿½ï¿½ï¿½Í·
	private BC0002RspBody body; //ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½

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
=======
package com.bocbus.project.bean;

public class BC0002Rsp {
	private BCRspHeader head; //±¨ÎÄÍ·
	private BC0002RspBody body; //±¨ÎÄÌå

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
>>>>>>> 9e0237e152cfaf5624a29824318048e21903ee4b
