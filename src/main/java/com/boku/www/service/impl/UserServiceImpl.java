/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserSserviceImpl
 * Author:   dell
 * Date:     2018/9/25 13:01
 * Description: user
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.service.impl;

import com.boku.www.mapper.TUserMapper;
import com.boku.www.pojo.TUser;
import com.boku.www.pojo.TUserExample;
import com.boku.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈user〉
 *
 * @author dell
 * @create 2018/9/25
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private TUserMapper userMapper;

	@Override
	public boolean isRegister(String username) {
		//根据username条件查询,判断用户是都存在
		TUserExample example = new TUserExample();
		TUserExample.Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(username);
		List<TUser> tUsers = userMapper.selectByExample(example);
		if(tUsers.size()>0){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 注册/保存用户
	 * @param user
	 */
	@Override
	public void register(TUser user) {
		userMapper.insert(user);
	}

	/**
	 * 登录
	 * @return
	 */
	/*@Override
	public TUser findUser(TUser user) {
		TUser tUser = userMapper.selectByPrimaryKey(user.getUserId());
		//如果传入的用户名和数据库查询的用户名密码相同，说明登录成功
		*//*System.out.println(user.getUserName());
		System.out.println(tUser.getUserName());
		System.out.println(user.getUserPassword());
		System.out.println(tUser.getUserPassword());*//*

		if(user.getUserName().equals(tUser.getUserName())&&user.getUserPassword().equals(tUser.getUserPassword())){
			return tUser;
		}else{
			//登录失败
			return null;
		}
	}*/

	@Override
	public TUser getUser(String id) {
		TUser user = userMapper.selectByPrimaryKey(id);
		return user;
	}

}