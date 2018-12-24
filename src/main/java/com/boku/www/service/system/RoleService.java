package com.boku.www.service.system;

import com.boku.www.pojo.system.URole;

import java.util.List;

public interface RoleService {
	/**
	 * 根据用户ID获取该用户所在组的角色权限
	 * @param obj
	 */
	public List<URole> findRoleByUid(Integer obj);
	/**
	 * 查询用户级别
	 * @return
	 */
	public String getRoleGrade();

}
