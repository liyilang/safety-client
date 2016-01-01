package com.service.impl;

import org.json.JSONException;
import org.json.JSONObject;

import com.filter.ServletFilter;
import com.service.Service;
import com.util.PathSegment;

public class IdCodeService implements Service {

	@Override
	public int service() {
		// TODO Auto-generated method stub
		if (PathSegment.pathSegments[3].equals("identify_code")) {
			String phone=PathSegment.pathSegments[2];
			Integer userId=(Integer) ServletFilter.threadLocalRequest.get().getSession().getAttribute("userId");
			//获取验证码
			
			String identifyCodeString="";
			JSONObject jsonObject=new JSONObject();
			try {
				jsonObject.put("userId", userId);
				jsonObject.put("identifyCode", identifyCodeString);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ServletFilter.threadLocalRequest.get().setAttribute("identifyCode", jsonObject);
			return 0;
		} else {
			return 999;
		}
	}

}
