/******************************************************************************
 * Copyright (C) 2010 ShangShai Bocsoft. All Rights Reserved.
 * δ���й���������������ʽ����ͬ�⣬�����κθ��ˡ����岻��ʹ�á����ơ�
 * �޸Ļ򷢲�������.
 *****************************************************************************/

package com.bocbus.project.dao;

import java.sql.SQLException;

import com.bocbus.project.bean.Userpf;


public interface UserDao {

	Userpf getUser(Userpf userpf) throws SQLException ;
	Integer ModifyUser(Userpf userpf) throws SQLException ;
}