package com.bocbus.project.action;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bocbus.project.bean.BC0006Req;
import com.bocbus.project.bean.BC0006Rsp;
import com.google.gson.Gson;

import com.bocbus.project.service.BusLineService;

public class QueryClosestStationAction {
	private BusLineService busLineService;
	
	public BusLineService getBusLineService() {
		return busLineService;
	}
	
	public void setBusLineService(BusLineService busLineService) {
		this.busLineService = busLineService;
	}
	
	public void QueryClosestStation() throws SQLException {
		HttpServletRequest request=ServletActionContext.getRequest();
		Gson gsonRequest = new Gson();
		String gsonString = request.getParameter("param");
		System.out.println(gsonString);
		try{
			BC0006Req requestContext=gsonRequest.fromJson(gsonString, BC0006Req.class);
			HttpServletResponse response=ServletActionContext.getResponse();

			response.setContentType("text/html");
			PrintWriter out;
			out = response.getWriter();

			BC0006Rsp responseContext=new BC0006Rsp();

			responseContext = busLineService.QueryClosestStation(requestContext);
			
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
