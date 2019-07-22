package com.boku.www.mapper.system;

import com.boku.www.pojo.system.UUser;
import com.boku.www.pojo.system.UUserExample;
import com.boku.www.pojo.system.UUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	 * 插入用户和角色的中间表
	 */
	public void insertUserRole(@Param("uid") int uid,@Param("rid") int rid);

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

	List<UUser> selectByExample(UUserExample example);

	int deleteByPrimaryKey(Integer id);

	UUser selectByPrimaryKey(Integer id);




}
