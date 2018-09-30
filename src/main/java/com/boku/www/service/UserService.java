package com.boku.www.service;

import com.boku.www.pojo.TUser;

public interface UserService {
	//用户是否已注册
	public boolean isRegister(String username);
	//用户注册
	public void register(TUser user);

	//用户登录
	//public TUser findUser(TUser user);

	public TUser getUser(String id);


}
