package com.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bean.Entity;
import com.dao.Dao;
import com.dao.impl.daoImpl;
import com.filter.ServletFilter;
import com.service.Service;

public class EntitiesService implements Service {
	
	@Override
	public int service() {
		// TODO Auto-generated method stub
		Dao dao=new daoImpl();
		int userId=(Integer) ServletFilter.threadLocalRequest.get().getSession().getAttribute("userId");
		List<Object> eresults=dao.simpleQuery("from Entity e where e.user.id='"+userId+"'");
		JSONArray jsonArray=new JSONArray();
		for (int i = 0; i < eresults.size(); i++) {
			Entity entity=(Entity) eresults.get(i);
			JSONObject jsonObject=new JSONObject();
			try {
				jsonObject.put("entityId", entity.getId());
				jsonObject.put("entityName", entity.getName());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jsonArray.put(jsonObject);
			
		}
	
		ServletFilter.threadLocalRequest.get().setAttribute("entities", jsonArray.length()==0?null:jsonArray);
		
		return 0;
	} 



}
