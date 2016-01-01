package com.util;


import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.filter.ServletFilter;



public class TokenGenerator {
	
	public static boolean isTokenValid(){
		HttpServletRequest request=ServletFilter.threadLocalRequest.get();
		String urlToken=request.getParameter("token");
		
		String sessionToken=(String) request.getSession().getAttribute("token");
		
		if (urlToken==null||urlToken.equals(""))
			return false;
		else if (urlToken.equals(sessionToken)) {
			return true;
		}else {
			return false;
		}
			
	}
	
	public static String  setToken(  ){
		HttpServletRequest request=ServletFilter.threadLocalRequest.get();
		String token=String.valueOf(new Random().nextInt(99999999));
		request.getSession().setAttribute("token", token);
		return token;
	}
	

	
}
