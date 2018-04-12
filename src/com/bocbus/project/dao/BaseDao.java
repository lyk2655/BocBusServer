package com.bocbus.project.dao;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class BaseDao {
	private SqlMapClientTemplate sqlMap;

	public SqlMapClientTemplate getSqlMap() {
		return sqlMap;
	}

	public void setSqlMap(SqlMapClientTemplate sqlMap) {
		this.sqlMap = sqlMap;
	}
}
