package com.boku.www.mapper.system;

import com.boku.www.pojo.system.UUserRole;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UUserRoleDao{

   /**
	* 增加对象
	* @param obj
	*/
   //public void add(SysMessageTep	 obj);

	public void insert(UUserRole userRole);

	public void deleteByUid(Integer uid);
}
