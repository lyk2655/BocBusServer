package com.bocbus.project.service;

import com.bocbus.project.bean.BC0005Req;
import com.bocbus.project.bean.BC0005Rsp;

public interface UploadLocationService {
	public BC0005Rsp updateLoacationProcess(BC0005Req req) throws Exception;
}