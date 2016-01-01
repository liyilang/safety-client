package com.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bean.EntityStatus;
import com.bean.GpsPoint;
import com.dao.Dao;
import com.dao.impl.daoImpl;
import com.filter.ServletFilter;
import com.service.Service;
import com.util.PathSegment;

public class EntityService implements Service {

	@Override
	public int service() {
		// TODO Auto-generated method stub
		if (PathSegment.pathSegments[4].equals("entity_status")) {
			return getStatus();
		}else if (PathSegment.pathSegments[4].equals("location")) {
			return getLocation();
		}else if (PathSegment.pathSegments[4].equals("locations")) {
			return getLocations();
		}
		return 999;
	}
	
	private int getStatus() {
		String entity_id=PathSegment.pathSegments[3];
		Dao dao=new daoImpl();
		EntityStatus status=(EntityStatus) dao.simpleQuery("from EntityStatus s where s.entity.id='"+entity_id+"'").get(0);
		dao.close();
		JSONObject battery=new JSONObject();
		try {
			battery.put("battery", status.getBattery());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ServletFilter.threadLocalRequest.get().setAttribute("battery", battery);
		return 0;
	}
	private int getLocation() {
		
		
		
		
		return 0;
	}
	private int getLocations() {
		String entity_id=PathSegment.pathSegments[3];
		String from=PathSegment.pathSegments[5];
		String to=PathSegment.pathSegments[6];
		long utime=Long.parseLong(to)-Long.parseLong(from);
		Dao dao=new daoImpl();
		List<Object> gresults=dao.simpleQuery("from GpsPoint g where g.entity.id='"+entity_id+"'"+" and utime<'"+utime+"'");
		JSONArray jsonArray=new JSONArray(); 
		for (int i = 0; i < gresults.size(); i++) {
			GpsPoint gpsPoint=(GpsPoint) gresults.get(i);
			JSONObject jsonObject=new JSONObject();
			try {
				jsonObject.put("lat", gpsPoint.getLat());
				jsonObject.put("lng", gpsPoint.getLng());
				jsonArray.put(jsonObject);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		ServletFilter.threadLocalRequest.get().setAttribute("locations", jsonArray);
		return 0;
	}

}
