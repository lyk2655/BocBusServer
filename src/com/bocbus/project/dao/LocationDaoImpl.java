
package com.bocbus.project.dao;
/**
 * @author wxh2525
 *
 * ���ĺ�̨���ݿ����
 */
import java.sql.SQLException;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.bocbus.project.bean.BC0001ReqBody;
import com.bocbus.project.bean.BC0002ReqBody;
import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.bean.BUS_LINE;
import com.bocbus.project.bean.Location;

public class LocationDaoImpl  implements LocationDao {

	 SqlMapClient sqlMapClient;   
	  
	 public void setSqlMapClient(SqlMapClient sqlMapClient) {  
	        this.sqlMapClient = sqlMapClient;  
	 }  
	  
	 public Location getLocation(Location location) throws SQLException{  
	        return (Location)this.sqlMapClient.queryForObject("user.queryLocation",location);  
	 }

	public BUS_BUS getBusLocationByLine(BC0002ReqBody bc0002ReqBody) throws SQLException {
		System.out.println("ddd"+bc0002ReqBody);
		return (BUS_BUS)this.sqlMapClient.queryForObject("user.getBusLocationByLine",bc0002ReqBody); 
	}

	

}
