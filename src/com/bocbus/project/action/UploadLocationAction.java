<<<<<<< HEAD
package com.bocbus.project.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bocbus.project.bean.BC0005Req;
import com.bocbus.project.bean.BC0005Rsp;
import com.bocbus.project.service.LocationService;
import com.bocbus.project.service.UploadLocationService;
import com.google.gson.Gson;

public class UploadLocationAction {
	private UploadLocationService uploadlocationService;
	
	public UploadLocationService getUploadLocationService () {
		return uploadlocationService;
	}
	public void setUploadLocationService(UploadLocationService value) {
		uploadlocationService=value;
	}
	
	public void uploadLocation()
	{
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		Gson gsonRequest = new Gson();
		String gsonString = request.getParameter("param");
		System.out.println(gsonString);
		try{
			BC0005Req requestContext=gsonRequest.fromJson(gsonString, BC0005Req.class);
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html");
			PrintWriter out;
			out = response.getWriter();

			BC0005Rsp responseContext=new BC0005Rsp();
			responseContext = uploadlocationService.updateLoacationProcess(requestContext);
			
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
=======
package com.bocbus.project.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bocbus.project.bean.BC0005Req;
import com.bocbus.project.bean.BC0005Rsp;
import com.bocbus.project.service.LocationService;
import com.bocbus.project.service.UploadLocationService;
import com.google.gson.Gson;

public class UploadLocationAction {
	private UploadLocationService uploadlocationService;
	
	public UploadLocationService getUploadLocationService () {
		return uploadlocationService;
	}
	public void setUploadLocationService(UploadLocationService value) {
		uploadlocationService=value;
	}
	
	public void uploadLocation()
	{
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		Gson gsonRequest = new Gson();
		String gsonString = request.getParameter("param");
		System.out.println(gsonString);
		try{
			BC0005Req requestContext=gsonRequest.fromJson(gsonString, BC0005Req.class);
			HttpServletResponse response=ServletActionContext.getResponse();
			//以下代码从JSON.java中拷过来的
			response.setContentType("text/html");
			PrintWriter out;
			out = response.getWriter();

			BC0005Rsp responseContext=new BC0005Rsp();
			responseContext = uploadlocationService.updateLoacationProcess(requestContext);
			
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
>>>>>>> 9e0237e152cfaf5624a29824318048e21903ee4b
