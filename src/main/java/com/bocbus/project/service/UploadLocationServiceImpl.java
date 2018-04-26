package com.bocbus.project.service;

import com.bocbus.project.bean.BC0005Req;
import com.bocbus.project.bean.BC0005ReqBody;
import com.bocbus.project.bean.BC0005Rsp;
import com.bocbus.project.bean.BC0005RspBody;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.bean.Location;
import com.bocbus.project.dao.BusBusDao;
import com.bocbus.project.dao.UploadLocationDao;
import com.bocbus.project.util.MyHttpRequest;

public class UploadLocationServiceImpl implements UploadLocationService {
	private UploadLocationDao uploadLocationDao;
	private BusBusDao busBusDao;

	public UploadLocationDao getUploadLocationDao() {
		return this.uploadLocationDao;
	}

	public void setUploadLocationDao(UploadLocationDao uploadLocationDao) {
		this.uploadLocationDao = uploadLocationDao;
	}
	
	public BusBusDao getBusBusDao() {
		return busBusDao;
	}

	public void setBusBusDao(BusBusDao busBusDao) {
		this.busBusDao = busBusDao;
	}

	@Override
	public BC0005Rsp updateLoacationProcess(BC0005Req req) throws Exception {
		// TODO Auto-generated method stub
		BC0005Rsp rsp = new BC0005Rsp();
		BC0005RspBody rspBody = new BC0005RspBody();
		BCRspHeader rspHead = new BCRspHeader();

		BC0005ReqBody reqBody = req.getBody();
		String sLine = req.getBody().getLine();
		String sLongitude = req.getBody().getLongitude();
		String sLatitude = req.getBody().getLatitude();
		
		BUS_BUS bus = busBusDao.queryBusByLine(sLine);
		
		BUS_BUS tmpbus = new BUS_BUS();
		tmpbus = bus;
		System.out.println("[bus]"+bus);
		System.out.println("[tmpbus]"+tmpbus);
		tmpbus.setBus_driver("huangfeihong");
		//int ret = busBusDao.updateBusByLineId(tmpbus);
		//根据上传的位置，更新pos3，  pos1=pos2，pos2=pos3，pos3=newpos
		//计算上一站点，下一站点
		//判断首次更新：更新时间相差1min（1min定时刷新）
		/* 首次更新：
		         1）if(time > 1min)  pos1=pos2=0, pos3=newpos, 上一站=0 下一站=0
		         2）if(pos1=0 && pos2=0)pos1=0， pos2=pos3，pos3=newpos  计算pos2到各个站点的距离，取min的站点，距离。 
		            计算pos3到该站点的距离 判断是向该站点前进还是远离+上下行标识 得到上一站点，下一站点。如果远离，重新计算下一站距离
		         3）if（pos1 = 0） 再确认一遍
		            pos1=pos2 pos2=pos3， pos3=newpos 计算pos3到下一站点的距离，判断距离是否缩小。如果扩大，pos1=0， pos2=0，pos3=newpos,上一站=0，下一站=0
		         4）if(pos1 !=0, pos2 != 0, pos3!=0)  pos1=pos2,pos2=pos3,pos3=newpos
		            计算pos3到下一站点的距离d
		            4.1） if(上一站 = 下一站)  更新 pos1=pos2 pos2=pos3， pos3=newpos ,计算下一站距离d
		                         if(d > 100m) pos1=pos2 pos2=pos3， pos3=newpos 更新下一站点，重新计算距离新的下一站距离和时间
		                         if(d <= 100m) 只更新pos1=pos2 pos2=pos3， pos3=newpos 不更新下一站距离时间
		            4.2） if(上一站 != 下一站)  更新 pos1=pos2 pos2=pos3， pos3=newpos ,计算下一站距离d
		            		if(d > 100m) 更新 距离d，时间t
		            		if(d <= 100m) 更新 上一站=下一站，距离d，时间t
		           
		
		
		
		
		
		String ip = "http://restapi.amap.com/v3/distance";
        //String param="key=8ad12a9140feb5b3ebdcd83abf021d45&origins=116.481028,39.989643|114.481028,39.989643|115.481028,39.989643&destination=114.465302,40.004717&type=1";
        String param="key=8ad12a9140feb5b3ebdcd83abf021d45&origins=116.481028,39.989643|114.481028,39.989643|115.481028,39.989643&destination=114.465302,40.004717&type=1";
        
        System.out.println("Get请求:"+MyHttpRequest.sendGet(ip, param,"utf-8"));

       // GAPI_DISTANCE ddd = new GAPI_DISTANCE();
		 */
		
		
		int i = uploadLocationDao.uploadBusLocationByLine(reqBody);

		System.out.print(i);
		if (i == 1) {
			rspHead.setERRMSG("更新班车["+sLine+"]位置["+sLongitude+","+sLatitude+"]成功");
			rspHead.setRTNSTS("0000");
			rsp.setHead(rspHead);
		} else {
			rspHead.setERRMSG("更新班车["+sLine+"]位置["+sLongitude+","+sLatitude+"]失败");
			rspHead.setRTNSTS("EEEE");
			rsp.setHead(rspHead);
		}
		return rsp;
	}
}
