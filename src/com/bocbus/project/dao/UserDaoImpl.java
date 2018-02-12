/******************************************************************************
 * Copyright (C) 2010 ShangShai Bocsoft. All Rights Reserved.
 * δ���й��������������ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á����ơ�
 * �޸Ļ򷢲������.
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
