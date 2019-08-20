/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   dell
 * Date:     2018/10/31 16:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.boku.www.service.system.impl;

import com.boku.www.mapper.TAreaAndCompanyMapper;
import com.boku.www.mapper.TUserForPersonageMapper;
import com.boku.www.mapper.system.URoleDao;
import com.boku.www.mapper.system.UUserDao;
import com.boku.www.mapper.system.UUserRoleDao;
import com.boku.www.pojo.*;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.pojo.system.UUserExample;
import com.boku.www.service.system.UserService;
import com.boku.www.utils.CurrentUser;
import com.boku.www.utils.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author dell
 * @create 2018/10/31
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UUserDao userDao;

	@Autowired
	private URoleDao roleDao;

	@Autowired
	private UUserRoleDao userRoleDao;

	@Autowired
	private TAreaAndCompanyMapper areaAndCompanyMapper;

	@Autowired
	private TUserForPersonageMapper userForPersonageMapper;
	@Override
	public UUser findByName(String name) {
		return userDao.findByName(name);
	}

	@Override
	public void updateLastLoginTime(UUser uUser){
		userDao.updateByPrimaryKey(uUser);
	}

	/**
	 * 根据单位添加单位id
	 */
	@Override
	public void addUnitId(){
		List<UUser> userList = userDao.selectAllUser();
		for (UUser user:userList) {
			if(StringUtils.isNotBlank(user.getCompany())){
				TAreaAndCompanyExample example = new TAreaAndCompanyExample();
				TAreaAndCompanyExample.Criteria criteria = example.createCriteria();
				criteria.andCompanyEqualTo(user.getCompany());
				List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(example);
				if(areaAndCompanyList!=null && areaAndCompanyList.size()>0){
					user.setCompanyId(areaAndCompanyList.get(0).getCompanyId());
					System.out.println(user);
					userDao.updateByPrimaryKey(user);
				}else {
					System.out.println(user.getUsername()+":"+user.getCompany()+"未找到对应的医院id");
				}
			}
		}
	}

	/**
	 * 添加省卫计委个人用户
	 * 	1.查询出省卫计委名下所有单位和单位id
	 * 	2.根据单位进行匹配用户单位
	 * 	3.将匹配的用户插入用户表
	 */
	@Override
	public void addPersonUser(){
		TAreaAndCompanyExample example = new TAreaAndCompanyExample();
		List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(example);
		for (TAreaAndCompany areaAndCompany:areaAndCompanyList) {
			TUserForPersonageExample userForPersonageExample = new TUserForPersonageExample();
			userForPersonageExample.createCriteria().andCompanyEqualTo(areaAndCompany.getCompany());
			List<TUserForPersonage> userForPersonageList = userForPersonageMapper.selectByExample(userForPersonageExample);
			for (TUserForPersonage userForPersonage:userForPersonageList) {
				UUser user = new UUser();
				user.setUsername(userForPersonage.getUsername());
				if(StringUtils.isNotBlank(user.getUsername())){
					// 将用户名作为盐值
					ByteSource salt = ByteSource.Util.bytes(user.getUsername());
					//如果修改密码，将密码根据加密方式存储
					String newPs = new SimpleHash("MD5", "123456", salt, 1024).toHex();
					user.setPswd(newPs);
				}
				user.setCompany(userForPersonage.getCompany());
				user.setArea(areaAndCompany.getCity());
				user.setCompanyId(areaAndCompany.getCompanyId());
				user.setCreateTime(new Date());
				user.setStatus("1");
				userDao.insert(user);
				//System.out.println(user);
			}
		}
		for(int i = 24318 ; i <= 195986; i++){
			userDao.insertUserRole(i,5);
		}

	}
	/**
	 * 分页条件查询用户
	 * 	admin和省卫计委可以查询所有的用户
	 * 	市卫生局查询本市的用户
	 * 	单位查询本单位的用户
	 * 	个人无此功能
	 */
	@Override
	public PageResult search(UUser user ,int pageNum, int pageSize){
		UUser currentUser = CurrentUser.returnCurrentUser();
		//查询当前用户的角色是否为单位管理员
		List<URole> roleList = roleDao.findRoleByUid(currentUser.getId());
		UUserExample example = new UUserExample();
		UUserExample.Criteria criteria = example.createCriteria();
		if(user!=null){
			if(StringUtils.isNotBlank(user.getArea())){
				criteria.andAreaEqualTo(user.getArea());
			}
			if(StringUtils.isNotBlank(user.getCompany())){
				criteria.andCompanyLike("%"+user.getCompany()+"%");
			}
			if(StringUtils.isNotBlank(user.getUsername())){
				criteria.andUsernameLike("%"+user.getUsername()+"%");
			}
		}
		//一个账号只有一个角色
		if(roleList!=null && roleList.size()>0){
			URole role = roleList.get(0);
			if("地市级".equals(role.getName())){
				criteria.andAreaEqualTo(currentUser.getArea());
			}else if("医院".equals(role.getName())) {
				if (currentUser.getCompanyId() != null && currentUser.getCompanyId().length() > 0) {
					criteria.andCompanyIdEqualTo(currentUser.getCompanyId());
				}
				if (currentUser.getArea() != null && currentUser.getArea().length() > 0) {
					//添加本人所属地区
					criteria.andAreaEqualTo(currentUser.getArea());
				}
			}
			PageHelper.startPage(pageNum, pageSize);
			Page<UUser> page = (Page<UUser>)userDao.selectByExample(example);
			PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
			pageResult.setRoleGrade(role.getName());
			return pageResult;
		}else {
			return null;
		}
	}

	/**
	 * 单位管理员增加用户,用户名是唯一的，数据库设置了唯一索引
	 * 	//role代表添加用户的角色
	 * 		2代表省级
	 * 		3代表市级
	 * 		4代表医院
	 * 		5代表个人
	 * 	user各个级别的用户，所添加的数据不同
	 * 		添加医院的用户需要重新查询社会信用代码作为单位的唯一标识
	 * 		添加个人的用户，需要查询单位表中的社会信用代码，补充进去
	 * 	admin账号可以添加任何角色的用户
	 * 	省级账号可以添加地市级、医院和个人用户
	 * 	地市级账号可以添加医院和个人用户
	 * 	医院账号可以添加个人用户
	 */
	@Override
	public String addUser(UUser user ,Integer role){
		URole uRole = CurrentUser.returnRole(roleDao);
		if("admin".equals(uRole.getName())){
			return insertUser(user,role);
		}else if("省级".equals(uRole.getName())) {
			if(3 == role || 4 == role || 5 == role){
				return insertUser(user,role);
			}else{
				return "对不起，您无权添加市级以上用户！";
			}
		}else if("地市级".equals(uRole.getName())) {
			if(4 == role || 5 == role){
				return insertUser(user,role);
			}else{
				return "对不起，您无权添加医院以上用户！";
			}
		}else if("医院".equals(uRole.getName())) {
			if(5 == role){
				return insertUser(user,role);
			}else{
				return "对不起，您无权添加个人以上用户！";
			}
		}
		return "添加用户失败";
	}
	private String insertUser(UUser user ,Integer role){
		//查询用户名是否存在
		List<UUser> ulist = userDao.selectByUsername(user.getUsername());
		if(ulist.isEmpty()){
			//如果是新增单位用户，需要新增单位用户的同时，更新单位表
			if(4 == role){
				if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPswd()) ||StringUtils.isBlank(user.getCompany())
						|| StringUtils.isBlank(user.getCompanyId()) || StringUtils.isBlank(user.getArea())){
					return "请补充完整信息！";
				}
				TAreaAndCompany areaAndCompany = new TAreaAndCompany();
				if(user!=null){
					if(StringUtils.isNotBlank(user.getArea())){
						areaAndCompany.setCity(user.getArea());
					}
					if(StringUtils.isNotBlank(user.getArea())){
						areaAndCompany.setDistrict(user.getDistrict());
					}
					if(StringUtils.isNotBlank(user.getArea())){
						areaAndCompany.setCompany(user.getCompany());
					}
					if(StringUtils.isNotBlank(user.getArea())){
						areaAndCompany.setCompanyId(user.getCompanyId());
					}
					TAreaAndCompanyExample areaAndCompanyExample = new TAreaAndCompanyExample();
					TAreaAndCompanyExample.Criteria criteria = areaAndCompanyExample.createCriteria();
					criteria.andCompanyIdEqualTo(user.getCompanyId());
					List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(areaAndCompanyExample);
					if(areaAndCompany!=null && areaAndCompanyList.isEmpty()){
						areaAndCompany.setStatus("1");
						areaAndCompanyMapper.insert(areaAndCompany);
					}else{
						return "社会信用代码已被占用，请重新录入！";
					}
				}
			}
			if(5 == role){
				if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPswd()) ||StringUtils.isBlank(user.getCompany())
						|| StringUtils.isBlank(user.getArea())){
					return "请补充完整信息！";
				}
				TAreaAndCompanyExample areaAndCompanyExample = new TAreaAndCompanyExample();
				TAreaAndCompanyExample.Criteria criteria = areaAndCompanyExample.createCriteria();
				criteria.andCompanyEqualTo(user.getCompany());
				List<TAreaAndCompany> areaAndCompanyList = areaAndCompanyMapper.selectByExample(areaAndCompanyExample);
				//这里可能会报空指针
				if(areaAndCompanyList!=null && areaAndCompanyList.size()>0){
					user.setCompanyId(areaAndCompanyList.get(0).getCompanyId());
				}

			}
			user.setCreateTime(new Date());
			user.setStatus("1");
			userDao.insert(user);
			//再次查询获取用户的id
			List<UUser> users = userDao.selectByUsername(user.getUsername());
			if(users!=null && users.size()>0){
				userDao.insertUserRole(users.get(0).getId(),role);
			}
		}else {
			return "用户名已存在";
		}
		return "添加用户成功";
	}

	/**
	 * 单位管理员修改用户
	 *	修改用户的时候不能修改单位id和单位名称
	 *	修改的内容为用户名和密码、邮箱，否则就只能删除和新增
	 *
	 *	1.根据用户名查询用户是否存在
	 *		如果存在，判断用户名是否为原本的用户，是原本的用户则不变，如果不是原本的用户则是修改了用户名，但是修改的用户名数据库中已存在，就不能再修改了
	 *		如果不存在，说明修改了用户名，并且新修改的用户名为唯一用户名
	 *	2.修改密码等信息
	 */
	@Override
	/*public String update(UUser user){
		boolean flag = false;
		List<UUser> ulist = userDao.selectByUsername(user.getUsername());
		UUser uUser = userDao.selectByPrimaryKey(user.getId());
		if(ulist.isEmpty()){
			//用户名已修改，但修改的新用户名为唯一用户
			flag = true;
		}else {
			//用户名未修改
			if(ulist.get(0).getUsername().equals(uUser.getUsername())){
				flag = true;
			}
		}
		if(flag){
			//如果单位、单位id和区域发生的变化
			if(StringUtils.isNotBlank(user.getArea())){
				if(!uUser.getArea().equals(user.getArea())){
					return "修改的内容为用户名和密码、邮箱，否则就只能删除和新增";
				}
			}if(StringUtils.isNotBlank(user.getCompanyId())){
				if(!uUser.getCompanyId().equals(user.getCompanyId())){
					return "修改的内容为用户名和密码、邮箱，否则就只能删除和新增";
				}
			}if(StringUtils.isNotBlank(user.getCompany())){
				if(!uUser.getCompany().equals(user.getCompany())){
					return "修改的内容为用户名和密码、邮箱，否则就只能删除和新增";
				}
			}
			*//*
			 * MD5加密：
			 * 使用SimpleHash类对原始密码进行加密。
			 * 第一个参数代表使用MD5方式加密
			 * 第二个参数为原始密码
			 * 第三个参数为盐值，即用户名
			 * 第四个参数为加密次数
			 * 最后用toHex()方法将加密后的密码转成String
			 * *//*
			if(StringUtils.isNotBlank(user.getPswd()) && StringUtils.isNotBlank(user.getUsername())){
				// 将用户名作为盐值
				ByteSource salt = ByteSource.Util.bytes(user.getUsername());
				//如果修改密码，将密码根据加密方式存储
				String newPs = new SimpleHash("MD5", user.getPswd(), salt, 1024).toHex();
				user.setPswd(newPs);
			}
			userDao.updateByPrimaryKeySelective(user);
		}else {
			return "用户名已存在";
		}

		return "修改用户成功";
	}*/

	public String update(UUser user) {
		UUserExample example = new UUserExample();
		List<UUser> userList = userDao.selectByExample(example);
		for (UUser uUser:userList) {
			//判断当前传过来的密码是否改变，如果改变，则需要通过md5加密，如果没改变，就不加密修改
			if(!CurrentUser.returnCurrentUser().getPswd().equals(user.getPswd())){
				if(StringUtils.isNotBlank(uUser.getPswd()) && StringUtils.isNotBlank(uUser.getUsername())){
					// 将用户名作为盐值
					ByteSource salt = ByteSource.Util.bytes(uUser.getUsername());
					//如果修改密码，将密码根据加密方式存储
					String newPs = new SimpleHash("MD5", uUser.getPswd(), salt, 1024).toHex();
					uUser.setPswd(newPs);
				}
			}
			userDao.updateByPrimaryKey(uUser);
		}

		return "修改用户成功";
	}

	/**
	 * 单位管理员删除用户
	 */
	@Override
	public void delete(Integer[] ids){
		for (Integer id:ids) {
			userDao.deleteByPrimaryKey(id);
			userRoleDao.deleteByUid(id);
		}
	}

	/**
	 *查询用户的信息和权限
	 */
	@Override
	public UUser selectUserAndRole() throws Exception{
		//Map map = new HashMap();
		//URole role = CurrentUser.returnRole(roleDao);
		UUser user = CurrentUser.returnCurrentUser();
		//map.put(role.getName(),user);
		return user;
	}
}