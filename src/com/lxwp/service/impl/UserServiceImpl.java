package com.lxwp.service.impl;

import com.lxwp.dao.UserDao;
import com.lxwp.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	public void setUserDao(UserDao userDao){
		this.userDao=userDao;
	}
	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.login(username,password);
	}

}
