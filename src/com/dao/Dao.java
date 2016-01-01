package com.dao;

import java.util.List;

public interface Dao {
	boolean save(Object object);
	boolean update(Object object);
	boolean delete(Object object);
	List<Object> simpleQuery(String hql);
	List<Object> multiQuery(String hql, List params);
	void close();
}
