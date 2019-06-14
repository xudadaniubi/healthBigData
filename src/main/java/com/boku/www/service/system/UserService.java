package com.boku.www.service.system;

import com.boku.www.pojo.system.UUser;

public interface UserService {
	/**
	 * 根据名字查询用户
	 * @param name
	 */
	public UUser findByName(String name);

	public void addUnitId();
}
