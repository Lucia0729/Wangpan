package com.lxwp.dao.impl;


import org.hibernate.Query;
import org.hibernate.Session;

import com.lxwp.dao.UserDao;
import com.lxwp.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public boolean login(String username, String password) {
		Session session=getHibernateTemplate().getSessionFactory().getCurrentSession();
		System.out.println(session);
		System.out.println(session.isOpen());
		
		StringBuilder sb=new StringBuilder(" FROM User WHERE username=:username AND password=:password ");
		Query query=session.createQuery(sb.toString());
		query.setString("username", username);
		query.setString("password", password);
		int num=0;
		num=query.list().size();
		System.out.println(session.isOpen());
		return num>0?true:false;
	}

	
}
