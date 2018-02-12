package com.bocbus.project.dao;

import java.sql.SQLException;

import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.bean.Location;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UploadLocationDaoImpl implements UploadLocationDao {
	SqlMapClient sqlMapClient;   
	  
	 public void setSqlMapClient(SqlMapClient sqlMapClient) {  
	        this.sqlMapClient = sqlMapClient;  
	 }  
	 
	 public Location getLocation(Location location) throws SQLException {
		 return (Location)this.sqlMapClient.queryForObject("user.queryLocation",location);  
	 }
	 
	 public Integer uploadLocation(Location location) throws SQLException{
		 BUS_BUS bus = new BUS_BUS();
		 bus.setBus_line(location.getLine());
		 bus.setBus_latitude(location.getLatitude());
		 bus.setBus_longitude(location.getLongitude());
		 return (Integer)this.sqlMapClient.update("user.uploadLocationForLine", bus);
	 }

	
}
