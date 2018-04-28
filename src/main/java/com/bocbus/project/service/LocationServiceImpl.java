package com.bocbus.project.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;

import com.bocbus.project.bean.BC0002Req;
import com.bocbus.project.bean.BC0002Rsp;
import com.bocbus.project.bean.BC0002RspBody;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.bean.BUS_LINE;
import com.bocbus.project.bean.GAPI_DISTANCE;
import com.bocbus.project.bean.GAPI_DISTANCE_PARAMETERS;
import com.bocbus.project.bean.Location;
import com.bocbus.project.dao.BusLineDao;
import com.bocbus.project.dao.LocationDao;
import com.bocbus.project.dao.UserDao;
import com.bocbus.project.util.GapiUtil;
import com.bocbus.project.util.MyHttpRequest;

public class LocationServiceImpl implements LocationService {
	
	private UserDao userDao;		
	private BusLineDao busLineDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	private LocationDao locationDao; 	
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}
	
	public BusLineDao getBusLineDao() {
		return busLineDao;
	}

	public void setBusLineDao(BusLineDao busLineDao) {
		this.busLineDao = busLineDao;
	}
	
	@Override
	public BC0002Rsp doGetLocationProcess(BC0002Req req) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ssss"+req);
		BC0002Rsp rsp = new BC0002Rsp();
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
		String sStanum = req.getBody().getStanum();
		System.out.println("doGetLocationProcess"+req.getBody());
		BUS_BUS bus = locationDao.getBusLocationByLine(req.getBody());
		
		if(bus == null)
		{
			rspHead.setERRMSG("查询班车位置失败，班车路线不存在");
			rspHead.setRTNSTS("EEEE");
			rsp.setHead(rspHead);
			return rsp;
		}
		List<BUS_LINE> lines = busLineDao.queryLineByLineId(sLine);
		int iStanum = Integer.parseInt(sStanum);
		BUS_LINE line = lines.get(iStanum-1);
		StringBuffer ori = new StringBuffer();
		StringBuffer des = new StringBuffer();
		ori.append(bus.getBus_longitude3()).append(",").append(bus.getBus_latitude3());
		des.append(line.getLine_longitude()).append(",").append(line.getLine_latitude());
		GAPI_DISTANCE_PARAMETERS pa = new GAPI_DISTANCE_PARAMETERS(ori.toString(),des.toString());
		GAPI_DISTANCE dis = GapiUtil.getDistance(pa);

		BC0002RspBody body = new BC0002RspBody();
		body.setBus(bus);
		body.setStanum(sStanum);
		body.setStadis(dis.getResults().get(0).getDistance());
		body.setStatime(dis.getResults().get(0).getDuration());
		System.out.println(bus);
		rsp.setBody(body);
		return rsp;
	}

}
