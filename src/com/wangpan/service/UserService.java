package com.wangpan.service;


import java.util.Map;

import com.wangpan.domain.User;

public interface UserService {

	User checkUser(Map<String, String> map) throws Exception;

	void ChangePass(User user);

}
