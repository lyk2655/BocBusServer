package com.bocbus.project.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.bocbus.project.bean.BC0002Req;
import com.bocbus.project.bean.BC0002RspBody;
import com.bocbus.project.bean.BCRspHeader;
import com.bocbus.project.bean.Userpf;
import com.bocbus.project.dao.UserDao;

public class UserServiceImpl implements UserService {
	UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void UpdateUser(BC0002Req req,BCRspHeader rspHead,BC0002RspBody rspBody) throws SQLException, Exception{
		//判断请求参数是否为空
		if ("".equals(req)||req==null){
			
			rspHead.setRTNSTS("M");
			rspHead.setERRMSG("请求参数为空");	
		 }else{
			//取出上送报体	
			String username = req.getHead().getUSRNAM();
			String userpassword=req.getHead().getUSRNAM();
			//校验上送报文
			if ("".equals(username)||(username==null)){
				rspHead.setRTNSTS("M");
				rspHead.setERRMSG("用户名为空");
			}else if ("".equals(userpassword)||(userpassword==null)){
				rspHead.setRTNSTS("M");
				rspHead.setERRMSG("用户密码为空");
			}else{
				//获取用户信息
				Userpf userBean = new Userpf();
				userBean.setUser_id(username);
				userBean = userDao.getUser(userBean);
					
				if (userBean==null){
					//为空，则表明用户不存在	
					rspHead.setRTNSTS("M");
					rspHead.setERRMSG("该用户名不存在!");
				}else{
					//验证用户密码
					if(!userBean.getPassword().equals(userpassword)){
						rspHead.setRTNSTS("M");
						rspHead.setERRMSG("密码错误!");
					}else{
						if(userBean.getFirst_login().equals("0") ){
							userBean.setFirst_login("1");
						}

						SimpleDateFormat curDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String sCurDate= curDate.toString();
						userBean.setLast_loging_time(sCurDate);
						try{
							userDao.ModifyUser(userBean);//更新用户信息
							//因返回报文需访问另外一个service，所以组织返回报文工作放在action中
							rspHead.setRTNSTS("T");
							rspHead.setERRMSG("");
						}
						catch(SQLException e){
							e.printStackTrace();
							rspHead.setRTNSTS("M");
							rspHead.setERRMSG("更新user表报错");
						}
					}
				}
			} 
		 }
	}
}
