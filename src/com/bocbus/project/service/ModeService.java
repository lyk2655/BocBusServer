package com.bocbus.project.service;

import com.bocbus.project.bean.BC0001Req;
import com.bocbus.project.bean.BC0001Rsp;

public interface ModeService {

	BC0001Rsp modeProcess(BC0001Req requestContext) throws Exception;

}
