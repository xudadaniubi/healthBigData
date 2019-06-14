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
import com.boku.www.mapper.system.UUserDao;
import com.boku.www.pojo.TAreaAndCompany;
import com.boku.www.pojo.TAreaAndCompanyExample;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.system.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
	private TAreaAndCompanyMapper areaAndCompanyMapper;
	@Override
	public UUser findByName(String name) {
		return userDao.findByName(name);
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

}