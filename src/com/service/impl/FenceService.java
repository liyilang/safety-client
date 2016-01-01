package com.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.enterprise.inject.New;

import org.json.JSONException;
import org.json.JSONObject;

import com.bean.Fence;
import com.bean.User;
import com.dao.Dao;
import com.dao.impl.daoImpl;
import com.filter.ServletFilter;
import com.service.Service;
import com.util.PathSegment;

public class FenceService implements Service { 

	@Override
	public int service() {
		// TODO Auto-generated method stub
		String method=ServletFilter.threadLocalRequest.get().getMethod();
		if (method.equalsIgnoreCase("get"))
			return getFence();
		else if (method.equalsIgnoreCase("post"))
			return postFence();
		else if (method.equalsIgnoreCase("put"))
			return putFence();
		else if (method.equalsIgnoreCase("delete"))
			return deleteFence();
		else 
			return 999;
	}
	
	private int getFence() {
		try {
			
			Dao dao=new daoImpl();
			String fence_id=PathSegment.pathSegments[3];
			System.out.println(fence_id);
			Fence fence=(Fence) (dao.simpleQuery("from Fence f where f.id='"+fence_id+"'").get(0));
			dao.close();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("type", "circle");
			jsonObject.put("coordinates", fence.getGeometry());
			ServletFilter.threadLocalRequest.get().setAttribute("geometry", jsonObject);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	private int postFence(){
		try {
			
			System.out.println(ServletFilter.threadLocalRequest.get().getParameter("GEOJSON"));
			JSONObject geoJson=new JSONObject(ServletFilter.threadLocalRequest.get().getParameter("GEOJSON")); 
			String geometry=geoJson.getString("coordinates");
			String type=geoJson.getString("type");
			Dao dao=new daoImpl();
			Fence fence=new Fence();  
			fence.setGeometry(geometry);
			//type无对应规则
			fence.setStatus(1);
			Integer userId=(Integer) ServletFilter.threadLocalRequest.get().getSession().getAttribute("userId");
			User user=(User) dao.simpleQuery("from User u where u.id='"+userId+"'").get(0);
			fence.setUser(user);
			dao.save(fence);
			JSONObject fenceId=new JSONObject().put("fenceId", fence.getId());
			ServletFilter.threadLocalRequest.get().setAttribute("fenceId", fenceId);
			dao.close();
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return 0;
	}
	
	private int putFence() {

		try {
			BufferedReader in;
			try {
				in = new BufferedReader(new InputStreamReader(ServletFilter.threadLocalRequest.get().getInputStream()));
				 String line=in.readLine();
				 JSONObject geoJson=new JSONObject(line); 
					String geometry=geoJson.getJSONObject("GEOJSON").getString("coordinates");
					Dao dao=new daoImpl();
					String fence_id=PathSegment.pathSegments[3];
					Fence fence=(Fence) dao.simpleQuery("from Fence f where f.id='"+fence_id+"'").get(0);
					fence.setGeometry(geometry);
					dao.update(fence);
					dao.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		   
			
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	private int deleteFence(){
		
			
		Dao dao=new daoImpl();
		String fence_id=PathSegment.pathSegments[3];
		Fence fence=(Fence) dao.simpleQuery("from Fence f where f.id='"+fence_id+"'").get(0);
		dao.delete(fence);
		dao.close();
		return 0;
	}

}
