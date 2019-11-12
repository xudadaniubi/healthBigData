package com.boku.www.service.system;

import com.boku.www.pojo.system.UUser;
import com.boku.www.utils.PageResult;

import java.util.List;
import java.util.Map;

public interface UserService {
	/**
	 * 根据名字查询用户
	 * @param name
	 */
	public UUser findByName(String name);

	/**
	 * 修改最后登录时间
	 */
	public void updateLastLoginTime(UUser uUser);

	public void addUnitId();

	public void addPersonUser();
	public PageResult search(UUser user , int pageNum, int pageSize);
	public String addUser(UUser user ,Integer role);
	public String update(UUser user);
	public void delete(Integer[] ids);
	public UUser selectUserAndRole() throws Exception;
	List<String> likeName(String name)throws Exception;

}
