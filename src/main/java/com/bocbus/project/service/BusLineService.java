package com.bocbus.project.service;

import java.sql.SQLException;

import com.bocbus.project.bean.BC0002Rsp;
import com.bocbus.project.bean.BC0004Req;
import com.bocbus.project.bean.BC0004Rsp;
import com.bocbus.project.bean.BC0006Req;
import com.bocbus.project.bean.BC0006ReqBody;
import com.bocbus.project.bean.BC0006Rsp;

public interface BusLineService {

	BC0004Rsp doBusLineQueryProcess(BC0004Req requestContext) throws SQLException;

	BC0006Rsp QueryClosestStation(BC0006Req requestContext) throws SQLException;


}
