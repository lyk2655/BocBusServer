package com.bocbus.project.service;


import java.sql.SQLException;
import java.util.List;

import com.bocbus.project.bean.BC0004Req;
import com.bocbus.project.bean.BC0004Rsp;
import com.bocbus.project.bean.BC0004RspBody;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.StationLocation;
import com.bocbus.project.dao.BusLineDao;

public class BusLineServiceImpl implements  BusLineService{

	private BusLineDao busLineDao;
	
	public BusLineDao getBusLineDao() {
		return busLineDao;
	}
	
	public void setBusLineDao(BusLineDao busLineDao) {
		this.busLineDao = busLineDao;
	}

	@Override
	public BC0004Rsp doBusLineQueryProcess(BC0004Req req) throws SQLException {
		System.out.println("doBusLineQueryProcess"+req);
		BC0004Rsp rsp = new BC0004Rsp();
		BC0004RspBody rspBody = new BC0004RspBody();
		BCRspHeader rspHead = new BCRspHeader();
		if(req.getBody().getLine() == null || "".equals(req.getBody().getLine()))
		{
			rspHead.setERRMSG("查询班车路线失败,班车路线为空");
			rspHead.setRTNSTS("EEEE");
			rsp.setHead(rspHead);
			return rsp;
		}
		rspHead.setERRMSG("查询路线["+req.getBody().getLine()+"]位置成功");
		rspHead.setRTNSTS("0000");
		rsp.setHead(rspHead);
		List<StationLocation> line = busLineDao.getLine(req.getBody());
		System.out.println(line);
		rspBody.setStationList(line);
		rsp.setBody(rspBody);
		return rsp;
	}
	
}
