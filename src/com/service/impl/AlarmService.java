package com.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.criteria.From;

import org.json.JSONException;
import org.json.JSONObject;

import com.bean.AlarmLog;
import com.bean.AlarmRule;
import com.bean.Fence;
import com.dao.Dao;
import com.dao.impl.daoImpl;
import com.filter.ServletFilter;
import com.service.Service;
import com.util.PathSegment;

public class AlarmService implements Service {

	@Override
	public int service() {
		// TODO Auto-generated method stub
		String method=ServletFilter.threadLocalRequest.get().getMethod();
		 if (method.equalsIgnoreCase("post"))
			return postAlarm();
		else if (method.equalsIgnoreCase("put"))
			return putAlarm();
		else if (method.equalsIgnoreCase("delete"))
			return deleteAlarm();
		else 
			return 999;
		
	}
	
	private int  postAlarm() {
		String type=ServletFilter.threadLocalRequest.get().getParameter("type");
		String notifyType=ServletFilter.threadLocalRequest.get().getParameter("notifyType");
		AlarmRule alarmRule=new AlarmRule();
		alarmRule.setType(Integer.parseInt(type));
		alarmRule.setNotifyType(Integer.parseInt(notifyType));
		Dao dao=new daoImpl();
		dao.save(alarmRule);
		JSONObject jsonObject=new JSONObject();
		try {
			jsonObject.put("alarmId", alarmRule.getId());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.close();
		ServletFilter.threadLocalRequest.get().setAttribute("alarmId", jsonObject);
		return 0;
	}
	
	private int  putAlarm() {
		String  alarmId=PathSegment.pathSegments[3];
		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(ServletFilter.threadLocalRequest.get().getInputStream()));
			 String line=in.readLine();
			 line="{"+line+"}";
			 JSONObject Json;
			
			Json = new JSONObject(line);
			
			 if (Json.has("status")) {
				 Dao dao=new daoImpl();
				 AlarmRule alarmRule=(AlarmRule) dao.simpleQuery("from AlarmRule where id='"+alarmId+"'").get(0);
				
				alarmRule.setStatus((Integer) Json.get("status"));
				
				 dao.update(alarmRule);
				 dao.close();
				 
				 return 0;
				 
			} else if (Json.has("notifyType")) {
				
				 Dao dao=new daoImpl();
				 AlarmRule alarmRule=(AlarmRule) dao.simpleQuery("from AlarmRule where id='"+alarmId+"'").get(0);
					
					alarmRule.setNotifyType((Integer) Json.get("notifyType"));
				 dao.update(alarmRule);
				 dao.close();
				 return 0;
			}else {
				return 999;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		return 999;
		
		
	}
	private int deleteAlarm() {
		String  alarmId=PathSegment.pathSegments[3];
		Dao dao=new daoImpl();
		AlarmRule alarmRule=(AlarmRule) dao.simpleQuery("from AlarmRule where id='"+alarmId+"'").get(0);
		dao.delete(alarmRule);
		dao.close();
		return 0;
	}

}
