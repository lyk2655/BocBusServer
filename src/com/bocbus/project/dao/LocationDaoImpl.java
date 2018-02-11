
package com.bocbus.project.dao;
/**
 * @author wxh2525
 *
 * ���ĺ�̨���ݿ����
 */
import java.sql.SQLException;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.bocbus.project.bean.Location;

public class LocationDaoImpl  implements LocationDao {

	 SqlMapClient sqlMapClient;   
	  
	 public void setSqlMapClient(SqlMapClient sqlMapClient) {  
	        this.sqlMapClient = sqlMapClient;  
	 }  
	  
	 public Location getLocation(Location location) throws SQLException{  
	        return (Location)this.sqlMapClient.queryForObject("user.queryLocation",location);  
	 }
	 

}
