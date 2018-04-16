package com.bocbus.project.dao;

import java.sql.SQLException;

import com.bocbus.project.bean.BC0001Req;
import com.bocbus.project.bean.BC0001ReqBody;
import com.bocbus.project.bean.BC0001Rsp;
import com.bocbus.project.bean.BUS_BUS;

public interface ModeDao {
	BUS_BUS queryBusByLine(BC0001ReqBody reqBody) throws SQLException;
}
