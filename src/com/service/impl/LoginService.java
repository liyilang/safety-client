package com.service.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.bean.User;
import com.dao.Dao;
import com.dao.impl.daoImpl;
import com.filter.ServletFilter;
import com.service.Service;
import com.util.MD5Util;

public class LoginService implements Service {
	private String userName;
	private String password;
	
	public LoginService(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	
	
	@Override
	public int service() {
		// TODO Auto-generated method stub
		Dao dao=new daoImpl();
		List<Object> uresults=dao.simpleQuery("from User where name='"+userName+"'");
		if (uresults.size()==1) {
			User user=(User) uresults.get(0);
			String savedPW=user.getPassword();
			int status=995;
			if (MD5Util.validatePassword(savedPW, password)) {
				status=0;
				HttpServletRequest request=ServletFilter.threadLocalRequest.get();
				request.getSession().setAttribute("userId", user.getId());
				request.getSession().setAttribute("userName", user.getName());
				//System.out.println(request.getSession().getAttribute("userName"));
			}
			dao.close();
			return status;
		}else if (uresults.size()==0) {
			dao.close();
			return 997;
		}else{
			dao.close();
			return 996;
		}
		
	}

}
