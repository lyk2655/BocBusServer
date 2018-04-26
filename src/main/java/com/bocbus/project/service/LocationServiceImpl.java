package com.bocbus.project.service;

import java.sql.SQLException;

import com.bocbus.project.bean.BC0002Req;
import com.bocbus.project.bean.BC0002Rsp;
import com.bocbus.project.bean.BC0002RspBody;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.bean.BUS_LINE;
import com.bocbus.project.bean.GAPI_DISTANCE;
import com.bocbus.project.bean.Location;
import com.bocbus.project.dao.LocationDao;
import com.bocbus.project.dao.UserDao;
import com.bocbus.project.util.MyHttpRequest;

public class LocationServiceImpl implements LocationService {


	private UserDao userDao;		
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	private LocationDao locationDao; 	
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}
	
	@Override
	public BC0002Rsp doGetLocationProcess(BC0002Req req) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ssss"+req);
		BC0002Rsp rsp = new BC0002Rsp();
		BC0002RspBody rspBody = new BC0002RspBody();
		BCRspHeader rspHead = new BCRspHeader();
		if(req.getBody().getLine() == null || "".equals(req.getBody().getLine()))
		{
			rspHead.setERRMSG("查询班车位置失败,班车路线为空");
			rspHead.setRTNSTS("EEEE");
			rsp.setHead(rspHead);
			return rsp;
		}
		rspHead.setERRMSG("查询班车["+req.getBody().getLine()+"]位置成功");
		rspHead.setRTNSTS("0000");
		rsp.setHead(rspHead);
		String sLine = req.getBody().getLine();
		System.out.println("doGetLocationProcess"+req.getBody());
		BUS_BUS bus = locationDao.getBusLocationByLine(req.getBody());
		
		if(bus == null)
		{
			rspHead.setERRMSG("查询班车位置失败，班车路线不存在");
			rspHead.setRTNSTS("EEEE");
			rsp.setHead(rspHead);
			return rsp;
		}
		System.out.println(bus);
		rspBody.setLatitude(bus.getBus_latitude3());
		rspBody.setLongitude(bus.getBus_longitude3());
		rspBody.setLastStation(bus.getBus_laststa());
		rspBody.setNextStation(bus.getBus_nextsta());
		rspBody.setNextDistance(bus.getBus_nextdis());
		rspBody.setNextTime(bus.getBus_nexttm());
		rsp.setBody(rspBody);
		return rsp;
	}

}
