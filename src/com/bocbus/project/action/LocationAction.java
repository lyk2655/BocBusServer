package com.bocbus.project.action;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.bocbus.project.bean.BC0002Req;
import com.bocbus.project.bean.BC0002Rsp;
import com.bocbus.project.bean.BCReqHeader;
import com.bocbus.project.service.LocationService;

public class LocationAction {
	
	private LocationService locationService;
	
	public LocationService getLocationService () {
		return locationService;
	}
	public void setLocationService(LocationService value) {
		locationService=value;
	}
	
	// BC0002-获取位置-获取班车当前位置
	public void doLocationSearch()
	{
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		Gson gsonRequest = new Gson();
		String gsonString = request.getParameter("param");
		System.out.println(gsonString);
		try{
			BC0002Req requestContext=gsonRequest.fromJson(gsonString, BC0002Req.class);
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html");
			PrintWriter out;
			out = response.getWriter();

			BC0002Rsp responseContext=new BC0002Rsp();
			responseContext = locationService.doGetLocationProcess(requestContext);
			
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
		//return SUCCESS;

	}


}
