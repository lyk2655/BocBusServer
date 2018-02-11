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
		//�ж���������Ƿ�Ϊ��
		if ("".equals(req)||req==null){
			
			rspHead.setRTNSTS("M");
			rspHead.setERRMSG("�������Ϊ��");	
		 }else{
			//ȡ�����ͱ���	
			String username = req.getHead().getUSRNAM();
			String userpassword=req.getHead().getUSRNAM();
			//У�����ͱ���
			if ("".equals(username)||(username==null)){
				rspHead.setRTNSTS("M");
				rspHead.setERRMSG("�û���Ϊ��");
			}else if ("".equals(userpassword)||(userpassword==null)){
				rspHead.setRTNSTS("M");
				rspHead.setERRMSG("�û�����Ϊ��");
			}else{
				//��ȡ�û���Ϣ
				Userpf userBean = new Userpf();
				userBean.setUser_id(username);
				userBean = userDao.getUser(userBean);
					
				if (userBean==null){
					//Ϊ�գ�������û�������	
					rspHead.setRTNSTS("M");
					rspHead.setERRMSG("���û���������!");
				}else{
					//��֤�û�����
					if(!userBean.getPassword().equals(userpassword)){
						rspHead.setRTNSTS("M");
						rspHead.setERRMSG("�������!");
					}else{
						if(userBean.getFirst_login().equals("0") ){
							userBean.setFirst_login("1");
						}

						SimpleDateFormat curDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String sCurDate= curDate.toString();
						userBean.setLast_loging_time(sCurDate);
						try{
							userDao.ModifyUser(userBean);//�����û���Ϣ
							//�򷵻ر������������һ��service��������֯���ر��Ĺ�������action��
							rspHead.setRTNSTS("T");
							rspHead.setERRMSG("");
						}
						catch(SQLException e){
							e.printStackTrace();
							rspHead.setRTNSTS("M");
							rspHead.setERRMSG("����user����");
						}
					}
				}
			} 
		 }
	}
}
