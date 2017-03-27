package com.wangpan.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

import com.wangpan.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * 增加对象
	 */
	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(t);
	}

	/**
	 * 删除对象
	 */
	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(t);
	}

	/**
	 * 根据id和对象的类来删除对象
	 */
	@Override
	public void delete(Class<? extends T> t, Serializable id) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(find(t, id));
	}

	/**
	 * 修改对象
	 */
	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(t);
	}

	/**
	 * 查询所有，根据对象的类查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<? extends T> t) {
		// TODO Auto-generated method stub
		return (List<T>) hibernateTemplate.find(" from " + t.getSimpleName());
	}

	/**
	 * 根据Id查询对象
	 */
	@Override
	public T find(Class<? extends T> t, Serializable id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(t, id);
	}

	/**
	 * 查询当前的记录数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public long getCount(Class<? extends T> t) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from " + t.getSimpleName();
		List<T> list = (List<T>) hibernateTemplate.find(hql);
		if (null != list && list.size() == 1)
			return (long) list.get(0);
		return 0;
	}

}
