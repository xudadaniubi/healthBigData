package com.boku.www.service.system;

import com.boku.www.pojo.system.UPermission;

import java.util.List;

public interface PermissionService {
	/**
	 * 根据用户id获取用户权限
	 * @param obj
	 */
	List<UPermission> findPermissionByUid(Integer id);
}
