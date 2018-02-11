package com.bocbus.project.dao;

import java.sql.SQLException;

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
		 return (Integer)this.sqlMapClient.update("user.uploadLocation", location);
	 }

	
}
