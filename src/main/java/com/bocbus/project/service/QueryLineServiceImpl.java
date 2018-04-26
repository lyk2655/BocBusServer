package com.bocbus.project.service;

import java.sql.SQLException;
import java.util.List;

import com.bocbus.project.bean.BC0003Req;
import com.bocbus.project.bean.BC0003Rsp;
import com.bocbus.project.bean.BC0003RspBody;
import com.bocbus.project.bean.BUS_LINE;
import com.bocbus.project.dao.QueryLineDao;

public class QueryLineServiceImpl implements QueryLineService {

	private QueryLineDao queryLineDao;
	public QueryLineDao getQueryLineDao() {
		return queryLineDao;
	}
	public void setQueryLineDao(QueryLineDao queryLineDao) {
		this.queryLineDao = queryLineDao;
	}

	public BC0003Rsp QueryLineProcess(BC0003Req requestContext) throws SQLException {
		String line = requestContext.getBody().getLine();
		System.out.println(line);
		List<BUS_LINE> lines = queryLineDao.queryLine(line);
		BC0003Rsp rsp = new BC0003Rsp();
		BC0003RspBody body = new BC0003RspBody();
		body.setLine_list(lines);
		rsp.setBody(body);
		return rsp;
	}
}
