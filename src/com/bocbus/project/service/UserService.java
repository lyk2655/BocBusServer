package com.bocbus.project.service;

import java.sql.SQLException;

import com.bocbus.project.bean.BC0002Req;
import com.bocbus.project.bean.BC0002RspBody;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.BC0002Req;
import com.bocbus.project.bean.BC0002RspBody;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.Userpf;

public interface UserService {
	public void UpdateUser(BC0002Req req,BCRspHeader rspHead,BC0002RspBody rspBody) throws SQLException, Exception;
}
