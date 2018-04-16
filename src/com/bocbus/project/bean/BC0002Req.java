<<<<<<< HEAD
package com.bocbus.project.bean;

public class BC0002Req {
	private BCReqHeader head; 
	private BC0002ReqBody body; 
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
	@Override
	public String toString() {
		return "BC0002Req [head=" + head + ", body=" + body + "]";
	}

}
=======
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
>>>>>>> 9e0237e152cfaf5624a29824318048e21903ee4b
