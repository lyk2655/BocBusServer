package com.bocbus.project.dao;

import java.sql.SQLException;

import com.bocbus.project.bean.BUS_BUS;
import com.ibatis.sqlmap.client.SqlMapClient;

public class BusBusDaoImpl implements BusBusDao{

	SqlMapClient sqlMapClient;
	

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	@Override
	public BUS_BUS queryBusByLine(String sLine) throws SQLException  {
		return (BUS_BUS) this.sqlMapClient.queryForObject("user.queryBusByLineId",sLine);
	}

	@Override
	public int updateBusByLineId(BUS_BUS bus) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("updateBusByBus"+bus);
		return this.sqlMapClient.update("user.updateBusByLineId", bus);
	}


	
	//update bus_bus
	//select bus_bus
}
