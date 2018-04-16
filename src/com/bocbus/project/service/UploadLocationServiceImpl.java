<<<<<<< HEAD
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
			rspHead.setERRMSG("æ›´æ–°ç­è½¦["+sLine+"]ä½ç½®["+sLongitude+","+sLatitude+"]æˆåŠŸ");
			rspHead.setRTNSTS("0000");
			rsp.setHead(rspHead);
		} else {
			rspHead.setERRMSG("æ›´æ–°ç­è½¦["+sLine+"]ä½ç½®["+sLongitude+","+sLatitude+"]å¤±è´¥");
			rspHead.setRTNSTS("EEEE");
			rsp.setHead(rspHead);
		}
		return rsp;
	}
}
=======
package com.bocbus.project.service;

import com.bocbus.project.bean.BC0005Req;
import com.bocbus.project.bean.BC0005Rsp;
import com.bocbus.project.bean.BC0005RspBody;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.Location;
import com.bocbus.project.dao.UploadLocationDao;

public class UploadLocationServiceImpl implements UploadLocationService{
	private UploadLocationDao uploadLocationDao;
	public UploadLocationDao getUploadLocationDao()
	{
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
		
		String sLine = req.getBody().getLINE();
		String sLongitude= req.getBody().getLONGITUDE();
		String sLatitude = req.getBody().getLATITUDE();
		Location location = new Location();
		location.setLine(sLine);
		location.setLongitude(sLongitude);
		location.setLatitude(sLatitude);
		
		int i = uploadLocationDao.uploadLocation(location);
		System.out.print(i);
		if(i == 1)
		{
			rspHead.setERRMSG("¸üÐÂ³É¹¦");
			rspHead.setRTNSTS("T");
			rsp.setHead(rspHead);
		}else
		{
			rspHead.setERRMSG("¸üÐÂÊ§°Ü");
			rspHead.setRTNSTS("F");
			rsp.setHead(rspHead);
		}
		return rsp;
	}
}
>>>>>>> 9e0237e152cfaf5624a29824318048e21903ee4b
