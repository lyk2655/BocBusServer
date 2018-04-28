package com.bocbus.project.service;


import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.bocbus.project.bean.BC0004Req;
import com.bocbus.project.bean.BC0004Rsp;
import com.bocbus.project.bean.BC0004RspBody;
import com.bocbus.project.bean.BC0006ReqBody;
import com.bocbus.project.bean.BC0006Rsp;
import com.bocbus.project.bean.BCReqHeader;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.BUS_LINE;
import com.bocbus.project.bean.GAPI_DISTANCE;
import com.bocbus.project.bean.GAPI_DISTANCE_PARAMETERS;
import com.bocbus.project.bean.GAPI_DISTANCE_RESULT;
import com.bocbus.project.bean.StationLocation;
import com.bocbus.project.dao.BusLineDao;
import com.bocbus.project.util.DateUtil;
import com.bocbus.project.util.GapiUtil;
import com.bocbus.project.bean.BC0006Req;

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

	@Override
	public BC0006Rsp QueryClosestStation(BC0006Req req) throws SQLException {
		String sline = req.getBody().getLine();
		String longitude = req.getBody().getLongitude();
		String latitude = req.getBody().getLatitude();
		
		//获取班车路线站点信息
		List<BUS_LINE> lines = busLineDao.queryLineByLineId(sline);
		DateUtil date= new DateUtil();
		StringBuffer origin = new StringBuffer();
		Iterator<BUS_LINE> iter = lines.iterator();
		BUS_LINE line = iter.next();
		origin.append(line.getLine_longitude()).append(",").append(line.getLine_latitude());
		while(iter.hasNext()) {
			line = iter.next();
			origin.append("|").append(line.getLine_longitude()).append(",").append(line.getLine_latitude());
		}
		
		StringBuffer des = new StringBuffer();
		des.append(longitude).append(",").append(latitude);
		
		GAPI_DISTANCE_PARAMETERS pa = new GAPI_DISTANCE_PARAMETERS(origin.toString(), des.toString());
		GAPI_DISTANCE dis = GapiUtil.getDistance(pa);
		GAPI_DISTANCE_RESULT min = GapiUtil.getMinDistance(dis);
		
		int minid = Integer.parseInt(min.getOrigin_id());
		line = lines.get(minid-1);
		
		BC0006Rsp rsp = new BC0006Rsp();
		BCReqHeader head = new BCReqHeader();
		head.setTRACDE("BC0006");
		head.setTRADAT(date.getDt());
		head.setTRATIM(date.getTm());
		head.setUSRNAM(req.getHead().getUSRNAM());
		rsp.setHead(head);
		rsp.setLine(line);

		return rsp;
	}
	
}
