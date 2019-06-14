package com.boku.www.mapper.system;

import com.boku.www.pojo.system.UUser;
import com.boku.www.pojo.system.UUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UUserDao{

   /**
	* 根据名字查询用户
	* @param obj
	*/
   public UUser findByName(String name);

   public void insert(UUser user);

	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<UUser> selectAllUser();

	public List<UUser> selectByUsername(String username);

	/**
	 * 根据id修改
	 */
	int updateByPrimaryKey(UUser user);
}
