package com.common;

import java.util.HashMap;
import java.util.Map;

public class StatusCode {
	
	//status code and status message
	public static final Map<Integer , String > status=new HashMap<Integer, String>(){
		{
			put(999, "system is busy,please try later");
			put(998, "username or entity already exist");
			put(997, "you did not register");
			put(996, "your account meets some problems");
			put(995, "password is incorrect");
			put(994, "token is invalid, please login");
			put(0, null);
		}
	};
	
}
