<<<<<<< HEAD
/******************************************************************************
 * Copyright (C) 2010 ShangShai Bocsoft. All Rights Reserved.
 * δ���й��������������ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á����ơ�
 * �޸Ļ򷢲������.
 *****************************************************************************/

package com.bocbus.project.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.bocbus.project.bean.Userpf;

@SuppressWarnings("unchecked")
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
=======
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
>>>>>>> 9e0237e152cfaf5624a29824318048e21903ee4b
