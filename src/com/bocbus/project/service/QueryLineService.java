package com.bocbus.project.service;

import java.sql.SQLException;

import com.bocbus.project.bean.BC0003Req;
import com.bocbus.project.bean.BC0003Rsp;

public interface QueryLineService {

	BC0003Rsp QueryLineProcess(BC0003Req requestContext) throws SQLException;

}
