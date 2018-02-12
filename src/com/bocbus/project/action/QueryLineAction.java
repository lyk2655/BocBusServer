package com.bocbus.project.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bocbus.project.bean.BC0003Req;
import com.bocbus.project.bean.BC0003Rsp;
import com.bocbus.project.service.QueryLineService;
import com.google.gson.Gson;

public class QueryLineAction {
	private QueryLineService queryLineService;

	public QueryLineService getQueryLineService() {
		return queryLineService;
	}

	public void setQueryLineService(QueryLineService queryLineService) {
		this.queryLineService = queryLineService;
	}
	
	public void doQueryLine() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Gson gsonRequest = new Gson();
		String gsonString = request.getParameter("param");
		System.out.println(gsonString);
		try{
			BC0003Req requestContext=gsonRequest.fromJson(gsonString, BC0003Req.class);
			HttpServletResponse response=ServletActionContext.getResponse();
			//以下代码从JSON.java中拷过来的
			response.setContentType("text/html");
			PrintWriter out;
			out = response.getWriter();

			BC0003Rsp responseContext=new BC0003Rsp();
			responseContext = queryLineService.QueryLineProcess(requestContext);
			
	    	Gson gsonResponse = new Gson();
	
	        System.out.println(gsonResponse.toJson(responseContext));
	        out.println(gsonResponse.toJson(responseContext));
	        out.flush();
			out.close();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
