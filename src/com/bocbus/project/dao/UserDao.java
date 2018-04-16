<<<<<<< HEAD
/******************************************************************************
 * Copyright (C) 2010 ShangShai Bocsoft. All Rights Reserved.
 * 未经中国银行软件中心正式书面同意，其他任何个人、团体不得使用、复制、
 * 修改或发布本软件.
 *****************************************************************************/

package com.bocbus.project.dao;

import java.sql.SQLException;

import com.bocbus.project.bean.Userpf;


public interface UserDao {

	Userpf getUser(Userpf userpf) throws SQLException ;
	Integer ModifyUser(Userpf userpf) throws SQLException ;
}
=======
/******************************************************************************
 * Copyright (C) 2010 ShangShai Bocsoft. All Rights Reserved.
 * 未经中国银行软件中心正式书面同意，其他任何个人、团体不得使用、复制、
 * 修改或发布本软件.
 *****************************************************************************/

package com.bocbus.project.dao;

import java.sql.SQLException;

import com.bocbus.project.bean.Userpf;


public interface UserDao {

	Userpf getUser(Userpf userpf) throws SQLException ;
	Integer ModifyUser(Userpf userpf) throws SQLException ;
}
>>>>>>> 9e0237e152cfaf5624a29824318048e21903ee4b
