<<<<<<< HEAD
package com.bocbus.project.bean;

public class BC0001Req {
	private BCReqHeader head;
	private BC0001ReqBody body;
	public BCReqHeader getHead(){
		return head;
	}
	public void setHead(BCReqHeader head){
		this.head = head;
	}
	public BC0001ReqBody getBody(){
		return this.body;
	}
	public void setBody(BC0001ReqBody body){
		this.body = body;
	}
	@Override
	public String toString() {
		return "BC0001Req [head=" + head + ", body=" + body + "]";
	}
	
}
=======
package com.bocbus.project.bean;

public class BC0001Req {
	private BCReqHeader head;
	private BC0001ReqBody body;
	public BCReqHeader getHead(){
		return head;
	}
	public void setHead(BCReqHeader head){
		this.head = head;
	}
	public BC0001ReqBody getBody(){
		return this.body;
	}
	public void setBody(BC0001ReqBody body){
		this.body = body;
	}
}
>>>>>>> 9e0237e152cfaf5624a29824318048e21903ee4b
