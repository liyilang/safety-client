package com.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.filter.ServletFilter;
import com.service.Service;

public class LogoutService implements Service {

	@Override
	public int service() {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletFilter.threadLocalRequest.get();
		HttpSession session=request.getSession();
		session.removeAttribute("token");
		session.removeAttribute("userName");
		session.removeAttribute("userId");
		return 0;
	}

}
