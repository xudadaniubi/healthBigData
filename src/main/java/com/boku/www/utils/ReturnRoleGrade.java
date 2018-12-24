/*

package com.boku.www.utils;
import com.boku.www.mapper.TProjectDataMapper;
import com.boku.www.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

*/
/**
 * 服务实现层
 * @author Administrator
 *
 *//*

@Service
@Transactional
public class ReturnRoleGrade {

	@Autowired
	private RoleService roleService;

	@Autowired
	private TProjectDataMapper projectDataMapper;
	*/
/**
	 * 根据角色添加查询条件
	 *
	 * 设置省、市、医院、个人四级权限，根据不同的权限，修改服务层代码，查询不同的数据，
	 *不同的权限返回不同的数据，同时返回权限级别，不同的权限显示不同的按钮（级别给前端进行判断，根据级别的不同，显示不同的按钮。
	 *如专家按钮，在个人级别的时候不现实，单位查询按钮在单位级别以下的不显示，地区选择按钮省级可选择地级市以下的地区和单位，
	 *地级市只能查询本市以下的地区和单位）
	 * @param criteria
	 *//*
*/
/*
	public String addCriteriaByRoles(TThesisForChineseExample.Criteria criteria) {
		Subject subject = SecurityUtils.getSubject();//获取subject
		UUser currentUser = (UUser)subject.getPrincipal();
		if (currentUser != null) {
			String roleGrade = null;
			System.out.println(currentUser.getId());
			projectDataMapper.selectByPrimaryKey(1);
			List<URole> rlist = roleService.findRoleByUid(currentUser.getId());//获取用户角色
			System.out.println(rlist);
			//根据角色的获取不同的数据，如果是admin或省级角色，查询所有的数据，如果是市级权限，查询本市的数据，
			// 如果是单位权限，查询本单位的数据，如果是个人的角色，查询个人的数据
			for (URole role : rlist) {
				if("admin".equals(role.getName())){
					//不添加任何限制条件
				}else if("省级".equals(role.getName())){
					//不添加任何限制条件
				}else if("地市级".equals(role.getName())){
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本市的名称
						criteria.andAreaEqualTo(currentUser.getArea());
					}
				}else if("医院".equals(role.getName())){
					if(currentUser.getCompany()!=null && currentUser.getCompany().length()>0){
						//添加本单位的名称
						criteria.andAuthorCompanyEqualTo(currentUser.getCompany());
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaEqualTo(currentUser.getArea());
					}
				}else if("个人".equals(role.getName())){
					if(currentUser.getCompany()!=null && currentUser.getCompany().length()>0){
						//添加本单位的名称
						criteria.andAuthorCompanyEqualTo(currentUser.getCompany());
					}
					if(currentUser.getArea()!=null && currentUser.getArea().length()>0){
						//添加本人所属地区
						criteria.andAreaEqualTo(currentUser.getArea());
					}
					if(currentUser.getUsername()!=null && currentUser.getUsername().length()>0){
						//添加本人的名称
						criteria.andAuthorEqualTo(currentUser.getUsername());
					}
				}
				roleGrade = role.getName();

			}
			return roleGrade;
		}
		return "该用户角色非法";
	}*//*

}*/
