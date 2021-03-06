package com.bocbus.project.dao;

import java.sql.SQLException;

import com.bocbus.project.bean.BC0005ReqBody;
import com.bocbus.project.bean.Location;

public interface UploadLocationDao {
	Location getLocation(Location location) throws SQLException ;
	Integer uploadLocation(Location location) throws SQLException ;
	Integer uploadBusLocationByLine(BC0005ReqBody reqBody) throws SQLException ;
}
