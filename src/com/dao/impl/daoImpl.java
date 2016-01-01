 package com.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.Entity;
import com.bean.User;
import com.dao.Dao;

public class daoImpl implements Dao {
	private Configuration cfg;
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction tx;
	
	{
		cfg=new Configuration().configure();
		sessionFactory=cfg.buildSessionFactory();
		session=sessionFactory.openSession();
		tx=session.beginTransaction();
	}
	
	@Override
	public boolean save(Object object) {
		// TODO Auto-generated method stub
		
		session.save(object);
		return true;
	}

	@Override
	public boolean update(Object object) {
		// TODO Auto-generated method stub
	
		session.update(object);
		return true;
	}

	@Override
	public boolean delete(Object object) {
		// TODO Auto-generated method stub
		
		session.delete(object);
		return true;
		
	}

	@Override
	public List<Object> simpleQuery(String hql) {
		// TODO Auto-generated method stub
	
		Query query = session.createQuery(hql);  
        List<Object> results = query.list();
		return results;
	}

	@Override
	public List<Object> multiQuery(String hql, List params) {
		// TODO Auto-generated method stub
		
		Query query = session.createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				query.setString(i, (String) params.get(i));
			}
			List<Object> results = query.list();
			return results;
		}
			return null;
   
	}
	
	public void close(){
		session.flush();
		tx.commit();
	    session.close(); 
		sessionFactory.close();
	}
	
	public static void main(String[] args){
		User user=new User("seth","13312","12342388");
		/*List<Object> list=new daoImpl().simpleQuery(hql);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			User user=(User) list.get(0);
			System.out.println(user.getPassword());
		}*/
		
		Entity entity1=new Entity();
		entity1.setId(11);
		entity1.setName("11");
		Entity entity2=new Entity();
		entity2.setId(22);
		entity2.setName("22");
		Set<Entity> entities=new HashSet<Entity>();
		entities.add(entity1);
		entities.add(entity2);
		user.setEntities(entities);
		entity1.setUser(user);
		entity2.setUser(user);
		Dao dao=new daoImpl();
		dao.save(user);
		dao.save(entity1);
		dao.save(entity2);
		dao.close();
	}

}
