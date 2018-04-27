package com.bocbus.project.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bocbus.project.bean.BC0002Req;
import com.bocbus.project.bean.BC0002Rsp;
import com.bocbus.project.bean.BC0002RspBody;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends  ActionSupport{
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void UserLogin() throws IOException, SQLException{
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println("request=" + request);
		
		//String method=request.getParameter("method");

		//System.out.println("method��");
		//System.out.println(method);
		Gson gsonRequest = new Gson();
		String gsonString = request.getParameter("param");
		System.out.println(gsonString);
		//��Ҫ�����ص��ͻ��˵Ķ���
		BCRspHeader responseHeader=new BCRspHeader();
		BUS_BUS responseBody=new BUS_BUS();
		BC0002Req requestContext=new BC0002Req();
		BC0002Rsp responseContext=new BC0002Rsp();
		PrintWriter out;
			
		try{
			requestContext=gsonRequest.fromJson(gsonString, BC0002Req.class);
			//userService.UpdateUser(requestContext, responseHeader, responseBody);
		}
		catch(JsonSyntaxException e){
			e.printStackTrace();
			responseHeader.setHeader("M", "����JSON��ʽ����");
		}
		catch(Exception e){
			e.printStackTrace();
			responseHeader.setHeader("M", "ConDao����");
		}
		finally{		
			//����ǰ�˱���
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html");
			out = response.getWriter();
			
			responseContext.setBody(responseBody);
			responseContext.setHead(responseHeader);
	    	Gson gsonResponse = new Gson();
	
	        System.out.println(gsonResponse.toJson(responseContext));
	        out.println(gsonResponse.toJson(responseContext));
	        out.flush();
			out.close();
		}
	}
}
