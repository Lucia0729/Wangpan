package com.lxwp.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

		void add(T eneity);
		void delete(T t);
		void delete(Class<? extends T> t,Serializable id);
		void update(T t);
		T find(Class<? extends T> t,Serializable id);
		List<T> findAll(Class<? extends T> t);
		long getCount(Class<? extends T> t);
}
