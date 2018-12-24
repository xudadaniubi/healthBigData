package com.boku.www.mapper.system;

import com.boku.www.pojo.system.UUser;
import com.boku.www.pojo.system.UUserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UUserDao{

   /**
	* 根据名字查询用户
	* @param obj
	*/
   public UUser findByName(String name);

   public void insert(UUser user);
}
