package com.bocbus.project.dao;

import java.sql.SQLException;

import com.bocbus.project.bean.BC0001ReqBody;
import com.bocbus.project.bean.BUS_BUS;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ModeDaoImpl implements ModeDao{
	SqlMapClient sqlMapClient;  

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public BUS_BUS queryBusByLine(BC0001ReqBody reqBody) throws SQLException {
		return (BUS_BUS)this.sqlMapClient.queryForObject("user.queryBusByLine", reqBody.getLine());
	}
	
	
}
