package com.bocbus.project.service;

import com.bocbus.project.bean.BC0005Req;
import com.bocbus.project.bean.BC0005ReqBody;
import com.bocbus.project.bean.BC0005Rsp;
import com.bocbus.project.bean.BC0005RspBody;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.Location;
import com.bocbus.project.dao.UploadLocationDao;

public class UploadLocationServiceImpl implements UploadLocationService {
	private UploadLocationDao uploadLocationDao;

	public UploadLocationDao getUploadLocationDao() {
		return this.uploadLocationDao;
	}

	public void setUploadLocationDao(UploadLocationDao uploadLocationDao) {
		this.uploadLocationDao = uploadLocationDao;
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
