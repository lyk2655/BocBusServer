package com.bocbus.project.dao;
/**
 * @author wxh2525
 *
 * ���ĺ�̨���ݿ����
 */
import java.sql.SQLException;

import com.bocbus.project.bean.BUS_BUS;
import com.bocbus.project.bean.Location;


public interface LocationDao {

	BUS_BUS getLocation(Location location) throws SQLException ;
}