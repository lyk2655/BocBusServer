package com.bocbus.project.service;

import java.sql.SQLException;

import com.bocbus.project.bean.BC0002Req;
import com.bocbus.project.bean.BC0002Rsp;
import com.bocbus.project.bean.BC0002RspBody;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.bean.Location;
import com.bocbus.project.dao.LocationDao;
import com.bocbus.project.dao.UserDao;

public class LocationServiceImpl implements LocationService {

	/*Icusrp-用户表*/
	private UserDao userDao;		
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/*ICTRNPF-交易流水表*/
	private LocationDao locationDao; 	
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}
	
	@Override
	public BC0002Rsp doGetLocationProcess(BC0002Req req) throws Exception {
		// TODO Auto-generated method stub
		BC0002Rsp rsp = new BC0002Rsp();
		BC0002RspBody rspBody = new BC0002RspBody();
		BCRspHeader rspHead = new BCRspHeader();
		rspHead.setERRMSG("");
		rspHead.setRTNSTS("T");
		rsp.setHead(rspHead);
		String sLine = req.getBody().getLINE();
		Location location = new Location();
		location.setLine(sLine);
		BUS_BUS bus = locationDao.getLocation(location);	
		rspBody.setLATITUDE(bus.getBus_latitude());
		rspBody.setLONGITUDE(bus.getBus_longitude());
		rsp.setBody(rspBody);
		return rsp;
	}

}
