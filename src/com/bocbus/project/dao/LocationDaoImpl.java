
package com.bocbus.project.dao;
/**
 * @author wxh2525
 *
 * 核心后台数据库操作
 */
import java.sql.SQLException;

import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.bean.Location;
import com.ibatis.sqlmap.client.SqlMapClient;

public class LocationDaoImpl  implements LocationDao {

	 SqlMapClient sqlMapClient;   
	  
	 public void setSqlMapClient(SqlMapClient sqlMapClient) {  
	        this.sqlMapClient = sqlMapClient;  
	 }  
	  
	 public BUS_BUS getLocation(Location location) throws SQLException{  
		 BUS_BUS bus = new BUS_BUS();
		 bus = (BUS_BUS) this.sqlMapClient.queryForObject("user.queryBusByLine", location.getLine());
		 System.out.println(bus);
	     return bus;
	 }
	 

}
