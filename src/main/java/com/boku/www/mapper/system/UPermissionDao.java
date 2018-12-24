package com.boku.www.mapper.system;


import com.boku.www.pojo.system.UPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UPermissionDao {



   /**
	* 根据用户id获取用户权限
	* @param obj
	*/
	List<UPermission> findPermissionByUid(Integer id);
}
