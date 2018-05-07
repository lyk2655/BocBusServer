package com.bocbus.project.service;

import java.util.Iterator;
import java.util.List;

import com.bocbus.project.bean.BC0005Req;
import com.bocbus.project.bean.BC0005ReqBody;
import com.bocbus.project.bean.BC0005Rsp;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.bean.BUS_LINE;
import com.bocbus.project.bean.GAPI_DISTANCE;
import com.bocbus.project.bean.GAPI_DISTANCE_PARAMETERS;
import com.bocbus.project.bean.GAPI_DISTANCE_RESULT;
import com.bocbus.project.bean.StationLocation;
import com.bocbus.project.dao.BusBusDao;
import com.bocbus.project.dao.BusLineDao;
import com.bocbus.project.dao.UploadLocationDao;
import com.bocbus.project.util.DateUtil;
import com.bocbus.project.util.GapiUtil;

public class UploadLocationServiceImpl implements UploadLocationService {
	private UploadLocationDao uploadLocationDao;
	private BusBusDao busBusDao;
	private BusLineDao busLineDao;

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

	public BusLineDao getBusLineDao() {
		return busLineDao;
	}

	public void setBusLineDao(BusLineDao busLineDao) {
		this.busLineDao = busLineDao;
	}

	// 判断首次更新：更新时间相差1min（1min定时刷新）
	// 位置没有变化，只更新时间
	/*
	 * 首次更新： 1）if(time > 1min) pos1=pos2=0, pos3=newpos, 上一站=0 下一站=0 2）if(pos1=0 &&
	 * pos2=0)pos1=0， pos2=pos3，pos3=newpos 计算pos2到各个站点的距离，取min的站点，距离。 计算pos3到该站点的距离
	 * 判断是向该站点前进还是远离+上下行标识 得到上一站点，下一站点。如果远离，重新计算下一站距离 3）if（pos1 = 0） 再确认一遍 pos1=pos2
	 * pos2=pos3， pos3=newpos 计算pos3到下一站点的距离，判断距离是否缩小。如果扩大，pos1=0，
	 * pos2=0，pos3=newpos,上一站=0，下一站=0 4）if(pos1 !=0, pos2 != 0, pos3!=0)
	 * pos1=pos2,pos2=pos3,pos3=newpos 计算pos3到下一站点的距离d 4.1） if(上一站 = 下一站) 更新
	 * pos1=pos2 pos2=pos3， pos3=newpos ,计算下一站距离d if(d > 100m) pos1=pos2 pos2=pos3，
	 * pos3=newpos 更新下一站点，重新计算距离新的下一站距离和时间 if(d <= 100m) 只更新pos1=pos2 pos2=pos3，
	 * pos3=newpos 不更新下一站距离时间 4.2） if(上一站 != 下一站) 更新 pos1=pos2 pos2=pos3，
	 * pos3=newpos ,计算下一站距离d if(d > 100m) 更新 距离d，时间t if(d <= 100m) 更新
	 * 上一站=下一站，距离d，时间t
	 */
	@Override
	public BC0005Rsp updateLoacationProcess(BC0005Req req) throws Exception {
		// TODO Auto-generated method stub
		BC0005Rsp rsp = new BC0005Rsp();
		BCRspHeader rspHead = new BCRspHeader();

		BC0005ReqBody reqBody = req.getBody();
		String sLine = req.getBody().getLine();
		String sLongitude = req.getBody().getLongitude();
		String sLatitude = req.getBody().getLatitude();
		//String sToc = req.getBody().getToc();

		// 获取班车路线站点信息
		List<BUS_LINE> lines = busLineDao.queryLineByLineId(sLine);
		System.out.println(lines);
		// 获取班车当前信息
		BUS_BUS bus = busBusDao.queryBusByLine(sLine);
		BUS_BUS tmpbus = new BUS_BUS();
		tmpbus = new BUS_BUS(bus);
		// 获取当前时间
		DateUtil date = new DateUtil();

		StringBuffer origin, ori, des;
		BUS_LINE line, next, last;
		GAPI_DISTANCE_PARAMETERS pa;
		GAPI_DISTANCE dis;
		GAPI_DISTANCE_RESULT min, nextResult, lastResult, newResult;
		int minid, lastid, nextid; // 距离最近站点，上一站点，下一站点对于Id（从1开始）
		if (sLatitude == null || sLatitude.equals("")) {
			sLatitude = "0";
		}
		if (sLongitude == null || sLongitude.equals("")) {
			sLongitude = "0";
		}
		if (bus == null) {
			rspHead.setERRMSG("班车[" + sLine + "]不存在");
			rspHead.setRTNSTS("EEEE");
			rsp.setHead(rspHead);
			rsp.setBody(null);
			return rsp;
		}
		if (bus.getBus_latitude1() == null || "".equals(bus.getBus_latitude1())) {
			bus.setBus_latitude1("0");
		}
		if (bus.getBus_longitude1() == null || "".equals(bus.getBus_longitude1())) {
			bus.setBus_longitude1("0");
		}
		if (bus.getBus_latitude2() == null || "".equals(bus.getBus_latitude2())) {
			bus.setBus_latitude2("0");
		}
		if (bus.getBus_longitude2() == null || "".equals(bus.getBus_longitude2())) {
			bus.setBus_longitude2("0");
		}
		if (bus.getBus_latitude3() == null || "".equals(bus.getBus_latitude3())) {
			bus.setBus_latitude3("0");
		}
		if (bus.getBus_longitude3() == null || "".equals(bus.getBus_longitude3())) {
			bus.setBus_longitude3("0");
		}

		// 位置没有变化，只更新时间
		if ((bus.getBus_latitude3().equals(sLatitude) && bus.getBus_longitude3().equals(sLongitude))) {
			tmpbus.setBus_chgdt(date.getDt());
			tmpbus.setBus_chgtm(date.getTm());
			int ret = busBusDao.updateBusByLineId(tmpbus);
			if (ret == 1) {
				rspHead.setERRMSG("A班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]不变，时间刷新成功：【"+tmpbus.getBus_laststa()+"-"+tmpbus.getBus_nextsta()+"("+tmpbus.getBus_nextdis()+")】");
				rspHead.setRTNSTS("0000");
				rsp.setHead(rspHead);
				rsp.setBody(tmpbus);
			} else {
				rspHead.setERRMSG("A班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]不变，时间刷新失败");
				rspHead.setRTNSTS("EEEE");
				rsp.setHead(rspHead);
				rsp.setBody(tmpbus);
			}
			return rsp;
		}

		// 判断是否需要矫正计算
		if (date.isTimeOut(bus.getBus_chgdt(), bus.getBus_chgtm()) || bus.getBus_latitude3().equals("0")
				|| bus.getBus_longitude3().equals("0") || sLatitude.equals("0") || sLongitude.equals("0")) {
			// pos1=pos2=0, pos3=newpos, 上一站=“” 下一站=“”,修改时间
			tmpbus.setBus_latitude1("0");
			tmpbus.setBus_longitude1("0");
			tmpbus.setBus_latitude2("0");
			tmpbus.setBus_longitude2("0");
			tmpbus.setBus_latitude3(sLatitude);
			tmpbus.setBus_longitude3(sLongitude);
			tmpbus.setBus_laststa("0");
			tmpbus.setBus_lasttm("999999999");
			tmpbus.setBus_nextsta("0");
			tmpbus.setBus_nexttm("999999999");
			tmpbus.setBus_nextdis("999999999");
			tmpbus.setBus_chgdt(date.getDt());
			tmpbus.setBus_chgtm(date.getTm());
			int ret = busBusDao.updateBusByLineId(tmpbus);
			if (ret == 1) {
				rspHead.setERRMSG("B初始化班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]成功-矫正计算:【"+tmpbus.getBus_laststa()+"-"+tmpbus.getBus_nextsta()+"("+tmpbus.getBus_nextdis()+")】");
				rspHead.setRTNSTS("0000");
				rsp.setHead(rspHead);
				rsp.setBody(tmpbus);

			} else {
				rspHead.setERRMSG("B初始化班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]失败");
				rspHead.setRTNSTS("EEEE");
				rsp.setHead(rspHead);
				rsp.setBody(tmpbus);
			}
			return rsp;
		} else if (bus.getBus_latitude2().equals("0") || bus.getBus_longitude2().equals("0")) {
			// 一分钟内更新且pos1=pos2=0
			// 计算posnew到各个站点的距离，取min的站点，距离。
			// 计算pos3到该站点的距离 判断是向该站点前进还是远离+上下行标识 得到上一站点，下一站点。如果远离，重新计算下一站距离
			// 更新 pos1=0， pos2=pos3，pos3=newpos ，上一站点，下一站点 修改时间
			origin = new StringBuffer();
			Iterator<BUS_LINE> iter = lines.iterator();
			line = iter.next();
			origin.append(line.getLine_longitude()).append(",").append(line.getLine_latitude());
			while (iter.hasNext()) {
				line = iter.next();
				origin.append("|").append(line.getLine_longitude()).append(",").append(line.getLine_latitude());
			}
			pa = new GAPI_DISTANCE_PARAMETERS(origin.toString(), sLongitude + "," + sLatitude);
			dis = GapiUtil.getDistance(pa);
			min = GapiUtil.getMinDistance(dis);
			int ln = Integer.parseInt(min.getDistance()); // posnew最近距离
			minid = Integer.parseInt(min.getOrigin_id()); // 最短距离对应的Id（从1开始）
			line = lines.get(minid - 1);
			// 班车到达
			if (ln <= 50) {
				tmpbus.setBus_latitude1("0");
				tmpbus.setBus_longitude1("0");
				tmpbus.setBus_latitude2(bus.getBus_latitude3());
				tmpbus.setBus_longitude2(bus.getBus_longitude3());
				tmpbus.setBus_latitude3(sLatitude);
				tmpbus.setBus_longitude3(sLongitude);
				tmpbus.setBus_laststa(line.getLine_stanum());
				tmpbus.setBus_lasttm(min.getDuration()); // 距离上一站点的时间
				tmpbus.setBus_nextsta(line.getLine_stanum());
				tmpbus.setBus_nexttm(min.getDuration());
				tmpbus.setBus_nextdis(min.getDistance());
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				int ret = busBusDao.updateBusByLineId(tmpbus);
				if (ret == 1) {
					rspHead.setERRMSG("C初始化班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]成功：pos2=0，且到达:【"+tmpbus.getBus_laststa()+"-"+tmpbus.getBus_nextsta()+"("+tmpbus.getBus_nextdis()+")】");
					rspHead.setRTNSTS("0000");
					rsp.setHead(rspHead);
					rsp.setBody(tmpbus);
				} else {
					rspHead.setERRMSG("C初始化班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]失败");
					rspHead.setRTNSTS("EEEE");
					rsp.setHead(rspHead);
					rsp.setBody(tmpbus);
				}
				return rsp;
			}

			StringBuffer ori3 = new StringBuffer();
			StringBuffer des3 = new StringBuffer();
			ori3.append(line.getLine_longitude()).append(",").append(line.getLine_latitude());
			des3.append(bus.getBus_longitude3()).append(",").append(bus.getBus_latitude3());
			GAPI_DISTANCE_PARAMETERS pa3 = new GAPI_DISTANCE_PARAMETERS(ori3.toString(), des3.toString());
			GAPI_DISTANCE dis3 = GapiUtil.getDistance(pa3);
			int l3 = Integer.parseInt(dis3.getResults().get(0).getDistance());// pos3距离

			// 判断上一站，下一站
			String line_stanum, line_id;
			if (ln < l3) {
				// 靠近该站点
				nextid = minid; // 上行，该站是下一站， 上一站-1
				lastid = minid == 1 ? minid : minid - 1;
			} else {
				// 远离该站点
				lastid = minid; // 上行，该站是上一站， 下一站+1
				nextid = minid == lines.size() ? minid : minid + 1;
			}
			next = lines.get(nextid - 1);
			last = lines.get(lastid - 1);
			nextResult = dis.getResults().get(nextid - 1);
			lastResult = dis.getResults().get(lastid - 1);

			// 更新 pos1=0， pos2=pos3，pos3=newpos ，上一站点，下一站点 修改时间
			tmpbus.setBus_latitude1("0");
			tmpbus.setBus_longitude1("0");
			tmpbus.setBus_latitude2(bus.getBus_latitude3());
			tmpbus.setBus_longitude2(bus.getBus_longitude3());
			tmpbus.setBus_latitude3(sLatitude);
			tmpbus.setBus_longitude3(sLongitude);
			tmpbus.setBus_laststa(last.getLine_stanum());
			tmpbus.setBus_lasttm(lastResult.getDuration()); // 距离上一站点的时间
			tmpbus.setBus_nextsta(next.getLine_stanum());
			tmpbus.setBus_nexttm(nextResult.getDuration());
			tmpbus.setBus_nextdis(nextResult.getDistance());
			tmpbus.setBus_chgdt(date.getDt());
			tmpbus.setBus_chgtm(date.getTm());
			int ret = busBusDao.updateBusByLineId(tmpbus);
			if (ret == 1) {
				rspHead.setERRMSG("E初始化班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]成功：pos2=0，重新得到上下站点:【"+tmpbus.getBus_laststa()+"-"+tmpbus.getBus_nextsta()+"("+tmpbus.getBus_nextdis()+")】");
				rspHead.setRTNSTS("0000");
				rsp.setHead(rspHead);
				rsp.setBody(tmpbus);
			} else {
				rspHead.setERRMSG("E初始化班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]失败");
				rspHead.setRTNSTS("EEEE");
				rsp.setHead(rspHead);
				rsp.setBody(tmpbus);
			}
			return rsp;
		} else {
			// 一分钟内更新,且(pos1=0 || pos1 != 0), pos2!=0 pos3 !=0
			// 计算posnew到下一站点的距离，判断距离是否缩小。如果扩大，pos1=0， pos2=0，pos3=newpos,上一站=0，下一站=0
			// 记录缩小： 更新班车位置 pos1=pos2 pos2=pos3， pos3=newpos
			ori = new StringBuffer();
			des = new StringBuffer();
			nextid = Integer.parseInt(bus.getBus_nextsta());
			if(nextid <= 1)
			{
				tmpbus.setBus_latitude1("0");
				tmpbus.setBus_longitude1("0");
				tmpbus.setBus_latitude2("0");
				tmpbus.setBus_longitude2("0");
				tmpbus.setBus_latitude3(sLatitude);
				tmpbus.setBus_longitude3(sLongitude);
				tmpbus.setBus_laststa("0");
				tmpbus.setBus_lasttm("999999999");
				tmpbus.setBus_nextsta("0");
				tmpbus.setBus_nexttm("999999999");
				tmpbus.setBus_nextdis("999999999");
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				int ret = busBusDao.updateBusByLineId(tmpbus);
				if (ret == 1) {
					rspHead.setERRMSG("B初始化班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]成功-初始化:【"+tmpbus.getBus_laststa()+"-"+tmpbus.getBus_nextsta()+"("+tmpbus.getBus_nextdis()+")】");
					rspHead.setRTNSTS("0000");
					rsp.setHead(rspHead);
					rsp.setBody(tmpbus);

				} else {
					rspHead.setERRMSG("B初始化班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]失败");
					rspHead.setRTNSTS("EEEE");
					rsp.setHead(rspHead);
					rsp.setBody(tmpbus);
				}
				return rsp;
			}
			next = lines.get(nextid - 1);
			ori.append(sLongitude).append(",").append(sLatitude);
			des.append(next.getLine_longitude()).append(",").append(next.getLine_latitude());
			pa = new GAPI_DISTANCE_PARAMETERS(ori.toString(), des.toString());
			dis = GapiUtil.getDistance(pa);
			newResult = dis.getResults().get(0);
			int ln = Integer.parseInt(dis.getResults().get(0).getDistance());// posnew距离
			int l3 = Integer.parseInt(bus.getBus_nextdis()); // pos3距离
			// 班车到达
			if (ln <= 50) {
				tmpbus.setBus_latitude1(bus.getBus_longitude2());
				tmpbus.setBus_longitude1(bus.getBus_latitude2());
				tmpbus.setBus_latitude2(bus.getBus_latitude3());
				tmpbus.setBus_longitude2(bus.getBus_longitude3());
				tmpbus.setBus_latitude3(sLatitude);
				tmpbus.setBus_longitude3(sLongitude);
				tmpbus.setBus_laststa(next.getLine_stanum());
				tmpbus.setBus_lasttm(newResult.getDuration()); // 距离上一站点的时间
				tmpbus.setBus_nextsta(next.getLine_stanum());
				tmpbus.setBus_nexttm(newResult.getDuration());
				tmpbus.setBus_nextdis(newResult.getDistance());
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				int ret = busBusDao.updateBusByLineId(tmpbus);
				if (ret == 1) {
					rspHead.setERRMSG("F更新班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]成功：正常情况，到达【"+tmpbus.getBus_laststa()+"-"+tmpbus.getBus_nextsta()+"("+tmpbus.getBus_nextdis()+")】");
					rspHead.setRTNSTS("0000");
					rsp.setHead(rspHead);
					rsp.setBody(tmpbus);
				} else {
					rspHead.setERRMSG("F更新班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]失败");
					rspHead.setRTNSTS("EEEE");
					rsp.setHead(rspHead);
					rsp.setBody(tmpbus);
				}
				return rsp;
			}
			else if (ln <= l3) {
				 //或距离缩小,只更新时间
				tmpbus.setBus_latitude1(bus.getBus_longitude2());
				tmpbus.setBus_longitude1(bus.getBus_latitude2());
				tmpbus.setBus_latitude2(bus.getBus_latitude3());
				tmpbus.setBus_longitude2(bus.getBus_longitude3());
				tmpbus.setBus_latitude3(sLatitude);
				tmpbus.setBus_longitude3(sLongitude);
				//tmpbus.setBus_laststa(next.getLine_stanum());
				//tmpbus.setBus_lasttm(newResult.getDuration()); // 距离上一站点的时间
				tmpbus.setBus_nextsta(next.getLine_stanum());
				tmpbus.setBus_nexttm(newResult.getDuration());
				tmpbus.setBus_nextdis(newResult.getDistance());
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				int ret = busBusDao.updateBusByLineId(tmpbus);
				if (ret == 1) {
					rspHead.setERRMSG("G更新班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]成功：正常情况，距离缩小:【"+tmpbus.getBus_laststa()+"-"+tmpbus.getBus_nextsta()+"("+tmpbus.getBus_nextdis()+")】");
					rspHead.setRTNSTS("0000");
					rsp.setHead(rspHead);
					rsp.setBody(tmpbus);
				} else {
					rspHead.setERRMSG("G更新班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]失败");
					rspHead.setRTNSTS("EEEE");
					rsp.setHead(rspHead);
					rsp.setBody(tmpbus);
				}
				return rsp;
			}else {
				// 距离变大，重新计算
				// pos1=0,pos2=0,pos3=posnew,上一站，下一站不变，修改时间
				tmpbus.setBus_latitude1("0");
				tmpbus.setBus_longitude1("0");
				tmpbus.setBus_latitude2("0");
				tmpbus.setBus_longitude2("0");
				tmpbus.setBus_latitude3(sLatitude);
				tmpbus.setBus_longitude3(sLongitude);
				tmpbus.setBus_chgdt(date.getDt());
				tmpbus.setBus_chgtm(date.getTm());
				int ret = busBusDao.updateBusByLineId(tmpbus);
				if (ret == 1) {
					rspHead.setERRMSG(
							"G初始化班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]成功，正常情况，距离变大，等待重新计算:【"+tmpbus.getBus_laststa()+"-"+tmpbus.getBus_nextsta()+"("+tmpbus.getBus_nextdis()+")】");
					rspHead.setRTNSTS("0000");
					rsp.setHead(rspHead);
					rsp.setBody(tmpbus);
				} else {
					rspHead.setERRMSG("G初始化班车[" + sLine + "]位置[" + sLongitude + "," + sLatitude + "]失败");
					rspHead.setRTNSTS("EEEE");
					rsp.setHead(rspHead);
					rsp.setBody(tmpbus);
				}
				return rsp;
			}
		}
	}

}
