package com.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import com.bean.Fence;
import com.dao.Dao;
import com.dao.impl.daoImpl;
import com.filter.ServletFilter;
import com.service.Service;

public class FencesService implements Service {

	@Override
	public int service() {
		// TODO Auto-generated method stub
		Dao dao=new daoImpl();
		int userId= (Integer) ServletFilter.threadLocalRequest.get().getSession().getAttribute("userId");
		List<Object> fresults=dao.simpleQuery("from Fence f where f.user.id='"+userId+"'");
		JSONArray jsonArray=new JSONArray();
		
		for (int i = 0; i < fresults.size(); i++) {
			Fence fence=(Fence) fresults.get(i);
			JSONObject jsonObject=new JSONObject();
			try {
				jsonObject.put("fenceId", fence.getId());
				jsonObject.put("name", fence.getName());
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jsonArray.put(jsonObject);
			
		}
		ServletFilter.threadLocalRequest.get().setAttribute("fences", jsonArray.length()==0?null:jsonArray);
		
		return 0;
	} 
}


