package com.boku.www.mapper.system;

import com.boku.www.pojo.system.URole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface URoleDao {
	
	/**
	 * 根据用户ID获取该用户所在组的角色权限
	 * @param obj
	 */
	public List<URole> findRoleByUid(Integer obj);
}
