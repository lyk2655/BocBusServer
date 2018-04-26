package com.bocbus.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.bocbus.project.bean.BUS_LINE;

public interface QueryLineDao {
	List<BUS_LINE> queryLine(String line) throws SQLException;
}
