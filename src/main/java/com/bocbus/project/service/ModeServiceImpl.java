package com.bocbus.project.service;

import com.bocbus.project.bean.BC0001Req;
import com.bocbus.project.bean.BC0001ReqBody;
import com.bocbus.project.bean.BC0001Rsp;
import com.bocbus.project.bean.BC0001RspBody;
import com.bocbus.project.bean.BC0005Rsp;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.bean.Location;
import com.bocbus.project.dao.ModeDao;
import com.google.gson.Gson;

public class ModeServiceImpl implements ModeService {
	private ModeDao modeDao;
	
	public ModeDao getModeDao() {
		return modeDao;
	}

	public void setModeDao(ModeDao modeDao) {
		this.modeDao = modeDao;
	}
	

	@Override
	public BC0001Rsp modeProcess(BC0001Req req) throws Exception {
		BC0001Rsp rsp = new BC0001Rsp();
		BC0001RspBody rspBody = new BC0001RspBody();
		BCRspHeader rspHead = new BCRspHeader();
		
		String sName = req.getHead().getUSRNAM();
		String sLine = req.getBody().getLine();
		String sMode= req.getBody().getMode();

		BUS_BUS bus = modeDao.queryBusByLine(req.getBody());
		System.out.println("班车路线【"+sLine+"】的信息:"+bus.toString());
		System.out.println("用户【"+sName+"】的模式是【"+sMode+"】");
		
		
		if(sMode.equals("D") && !sName.equals(bus.getBus_uploadid()))
		{
			rspHead.setRTNSTS("EEEE");
			rspHead.setERRMSG("用户["+sName+"]在班车路线["+sLine+"]"+"模式为["+sMode+"]错误");
			rsp.setHead(rspHead);
		}
		else
		{
			rspHead.setRTNSTS("0000");
			rspHead.setERRMSG("用户["+sName+"]在班车路线["+sLine+"]"+"模式为["+sMode+"]正确");
			rsp.setHead(rspHead);
		}
		return rsp;
	}
}
