<<<<<<< HEAD
package com.bocbus.project.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bocbus.project.bean.BC0001Req;
import com.bocbus.project.bean.BC0001Rsp;
import com.bocbus.project.bean.BC0005Req;
import com.bocbus.project.bean.BC0005Rsp;
import com.bocbus.project.service.ModeService;
import com.google.gson.Gson;

public class ModeAction {
	private ModeService modeService;

	public ModeService getModeService() {
		return modeService;
	}

	public void setModeService(ModeService modeService) {
		this.modeService = modeService;
	}
	
	//BC0001-搴旂敤妯″紡閫夋嫨
	public void modeAction() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Gson gsonRequest = new Gson();
		String gsonString = request.getParameter("param");
		System.out.println(gsonString);
		try{
			BC0001Req requestContext=gsonRequest.fromJson(gsonString, BC0001Req.class);
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html");
			PrintWriter out;
			out = response.getWriter();

			BC0001Rsp responseContext=new BC0001Rsp();
			responseContext = modeService.modeProcess(requestContext);
			
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
=======
package com.bocbus.project.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bocbus.project.bean.BC0001Req;
import com.bocbus.project.bean.BC0001Rsp;
import com.bocbus.project.bean.BC0005Req;
import com.bocbus.project.bean.BC0005Rsp;
import com.bocbus.project.service.ModeService;
import com.google.gson.Gson;

public class ModeAction {
	private ModeService modeService;

	public ModeService getModeService() {
		return modeService;
	}

	public void setModeService(ModeService modeService) {
		this.modeService = modeService;
	}
	
	public void modeAction() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Gson gsonRequest = new Gson();
		String gsonString = request.getParameter("param");
		System.out.println(gsonString);
		try{
			BC0001Req requestContext=gsonRequest.fromJson(gsonString, BC0001Req.class);
			HttpServletResponse response=ServletActionContext.getResponse();
			//以下代码从JSON.java中拷过来的
			response.setContentType("text/html");
			PrintWriter out;
			out = response.getWriter();

			BC0001Rsp responseContext=new BC0001Rsp();
			responseContext = modeService.modeProcess(requestContext);
			
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
>>>>>>> 9e0237e152cfaf5624a29824318048e21903ee4b
