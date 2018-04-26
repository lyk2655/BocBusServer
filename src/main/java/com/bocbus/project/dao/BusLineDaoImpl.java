package com.bocbus.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.bocbus.project.bean.BC0004ReqBody;
import com.bocbus.project.bean.BUS_LINE;
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

	@Override
	public List<BUS_LINE> queryLineByLineId(String line_id) throws SQLException {
		return this.sqlMapClient.queryForList("user.queryLineByLineId",line_id);
	}

	@Override
	public BUS_LINE queryLineByIdAndStanum(String line_id, String line_stanum) throws SQLException {
		return (BUS_LINE) this.sqlMapClient.queryForObject("user.queryLineByIdAndStanum",line_id,line_stanum);
	}
	

}
