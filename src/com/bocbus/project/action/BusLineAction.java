package com.bocbus.project.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bocbus.project.bean.BC0002Req;
import com.bocbus.project.bean.BC0002Rsp;
import com.bocbus.project.bean.BC0004Req;
import com.bocbus.project.bean.BC0004Rsp;
import com.bocbus.project.service.BusLineService;
import com.google.gson.Gson;

public class BusLineAction {
	private BusLineService busLineService;
	
	public BusLineService getBusLineService() {
		return busLineService;
	}

	public void setBusLineService(BusLineService busLineService) {
		this.busLineService = busLineService;
	}

	public void doBusLineQuery()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		Gson gsonRequest = new Gson();
		String gsonString = request.getParameter("param");
		System.out.println("doBusLineQuery"+gsonString);
		try{
			BC0004Req requestContext=gsonRequest.fromJson(gsonString, BC0004Req.class);
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html");
			PrintWriter out;
			out = response.getWriter();

			BC0004Rsp responseContext=new BC0004Rsp();
			
			System.out.println("requestContext"+requestContext);
			responseContext = busLineService.doBusLineQueryProcess(requestContext);
			
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
