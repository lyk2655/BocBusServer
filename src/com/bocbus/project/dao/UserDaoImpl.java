/******************************************************************************
 * Copyright (C) 2010 ShangShai Bocsoft. All Rights Reserved.
 * 未经中国银行软件中心正式书面同意，其他任何个人、团体不得使用、复制、
 * 修改或发布本软件.
 *****************************************************************************/

package com.bocbus.project.dao;

import java.sql.SQLException;

import com.bocbus.project.bean.Userpf;
import com.ibatis.sqlmap.client.SqlMapClient;

public class UserDaoImpl  implements UserDao {

	 SqlMapClient sqlMapClient;   
	  
	 public void setSqlMapClient(SqlMapClient sqlMapClient) {  
	        this.sqlMapClient = sqlMapClient;  
	 }  
	  

	 public Userpf getUser(Userpf userpf) throws SQLException{  
	        return (Userpf)this.sqlMapClient.queryForObject("user.queryUser",userpf);  
	 }
	 

	 public Integer ModifyUser(Userpf userpf) throws SQLException{  
	        return (Integer)this.sqlMapClient.update("user.updateuser",userpf);  
	 }
	 

}
