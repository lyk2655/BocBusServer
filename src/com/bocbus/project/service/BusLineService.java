package com.bocbus.project.service;

import java.sql.SQLException;

import com.bocbus.project.bean.BC0002Rsp;
import com.bocbus.project.bean.BC0004Req;
import com.bocbus.project.bean.BC0004Rsp;

public interface BusLineService {

	BC0004Rsp doBusLineQueryProcess(BC0004Req requestContext) throws SQLException;

}
