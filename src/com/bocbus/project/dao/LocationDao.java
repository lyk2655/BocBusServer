<<<<<<< HEAD
package com.bocbus.project.dao;
/**
 * @author wxh2525
 *
 * ï¿½ï¿½ï¿½Äºï¿½Ì¨ï¿½ï¿½ï¿½Ý¿ï¿½ï¿½ï¿½ï¿½
 */
import java.sql.SQLException;

import com.bocbus.project.bean.BC0002ReqBody;
import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.bean.BUS_LINE;
import com.bocbus.project.bean.Location;


public interface LocationDao {

	Location getLocation(Location location) throws SQLException ;

	BUS_BUS getBusLocationByLine(BC0002ReqBody bc0002ReqBody) throws SQLException;
=======
package com.bocbus.project.dao;
/**
 * @author wxh2525
 *
 * ºËÐÄºóÌ¨Êý¾Ý¿â²Ù×÷
 */
import java.sql.SQLException;

import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.bean.Location;


public interface LocationDao {

	BUS_BUS getLocation(Location location) throws SQLException ;
>>>>>>> 9e0237e152cfaf5624a29824318048e21903ee4b
}