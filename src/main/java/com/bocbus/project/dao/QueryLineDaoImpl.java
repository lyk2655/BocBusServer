package com.bocbus.project.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bocbus.project.bean.BUS_LINE;
import com.ibatis.sqlmap.client.SqlMapClient;

public class QueryLineDaoImpl implements QueryLineDao {
	SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	@SuppressWarnings("unchecked")
	public List<BUS_LINE> queryLine(String line) throws SQLException {
		// TODO Auto-generated method stub
		List<BUS_LINE> lines = new ArrayList<BUS_LINE>();
		lines = (List<BUS_LINE>)this.sqlMapClient.queryForList("user.queryLineByLine", line);
		return lines;
	}   
}
