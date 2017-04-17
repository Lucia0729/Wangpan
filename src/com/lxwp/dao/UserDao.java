package com.lxwp.dao;

import com.lxwp.domain.User;

public interface UserDao extends BaseDao<User>{

	boolean login(String username, String password);

}
