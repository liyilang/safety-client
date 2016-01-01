package com.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bean.Entity;
import com.bean.User;
import com.dao.Dao;
import com.dao.impl.daoImpl;
import com.service.Service;

public class SignInService implements Service {
	private String userName;
	private String password;
	private String phone;
	private String entityId;
	
	public SignInService(String userName, String password, String phone,
			String entityId) {
		super();
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.entityId = entityId;
	}
	
	public int service(){
		
		Dao dao=new daoImpl();
		List<Object> uresults=dao.simpleQuery("from User where name='"+userName+"'");
		List<Object> eresults=dao.simpleQuery("from Entity where id='"+entityId+"'");
		if (uresults.isEmpty()&&eresults.isEmpty()) {
			User user=new User(userName, password, phone);
			Entity entity=new Entity();
			entity.setId(Integer.valueOf(entityId));
			entity.setName(entityId);
			
			Set<Entity> entities=new HashSet<Entity>();
			entities.add(entity);
			user.setEntities(entities);
			entity.setUser(user);
			dao.save(user);
			dao.save(entity);
			dao.close();
			//注册成功
			return 0;
		}else if(!uresults.isEmpty()||!eresults.isEmpty()) {
			//用户名已注册或设备已注册
			dao.close();
			return 998;
		}else {
			//系统出错
			dao.close();
			return 999;
		}
		
		
	}



	
	

}
