package com.bocbus.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.bocbus.project.bean.BC0004ReqBody;
import com.bocbus.project.bean.StationLocation;
import com.ibatis.sqlmap.client.SqlMapClient;

public class BusLineDaoImpl implements BusLineDao{

	SqlMapClient sqlMapClient;
	

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	@Override
	public List<StationLocation> getLine(BC0004ReqBody body) throws SQLException {
		// TODO Auto-generated method stub
		return this.sqlMapClient.queryForList("user.queryLine",body);
	}

}
