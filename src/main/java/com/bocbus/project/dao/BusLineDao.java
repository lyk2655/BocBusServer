package com.bocbus.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.bocbus.project.bean.BC0004ReqBody;
import com.bocbus.project.bean.StationLocation;

public interface BusLineDao {

	List<StationLocation> getLine(BC0004ReqBody body) throws SQLException;

}
