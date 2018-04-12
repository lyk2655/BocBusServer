package com.bocbus.project.service;

import com.bocbus.project.bean.BC0002Req;
import com.bocbus.project.bean.BC0002Rsp;

public interface LocationService {
	public BC0002Rsp doGetLocationProcess(BC0002Req req) throws Exception;
}
