package com.bocbus.project.dao;

import java.sql.SQLException;

import com.bocbus.project.bean.BUS_BUS;

public interface BusBusDao {

	BUS_BUS queryBusByLine(String sLine) throws SQLException;

	int updateBusByLineId(BUS_BUS tmpbus) throws SQLException;

}
