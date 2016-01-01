package com.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;

import com.bean.User;
import com.dao.Dao;
import com.dao.impl.daoImpl;
import com.filter.ServletFilter;
import com.service.Service;
import com.util.MD5Util;
import com.util.PathSegment;

public class PwdService implements Service {

	@Override
	public int service() {
		// TODO Auto-generated method stub
		String userId=PathSegment.pathSegments[3];
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(ServletFilter.threadLocalRequest.get().getInputStream()));
	
		String line=in.readLine();
		line="{"+line+"}";
		System.out.println(line);
		JSONObject Json = new JSONObject(line);
		if (Json.has("password")) {
			String passsword=Json.getString("password");
			System.out.println(passsword);
			passsword=MD5Util.generatePassword(passsword);
			Dao dao=new daoImpl();
			User user=(User) dao.simpleQuery("from User where id='"+userId+"'").get(0);
			user.setPassword(passsword);
			dao.update(user);
			dao.close();
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JSONException e1) {
			// TODO: handle exception
		}
		
		return 0;
	}

}
