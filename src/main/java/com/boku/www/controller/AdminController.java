package com.boku.www.controller;

import com.boku.www.mapper.system.URoleDao;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.system.RoleService;
import com.boku.www.service.system.UserService;
import com.boku.www.utils.PageResult;
import com.boku.www.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**   
* @Title: CityRestController.java 
* @Package com.bamboo.springboot.controller 
* @Description: 用户登陆权限认证管理控制器
* @author bamboo  <a href="mailto:zjcjava@163.com?subject=hello,bamboo&body=Dear Bamboo:%0d%0a描述你的问题：">Bamboo</a>   
* @date 2017年4月21日 下午5:51:36 
* @version V1.0   
*/
@RestController
//@RequestMapping("/user")
@CrossOrigin//解决跨域问题
public class AdminController {
	
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private URoleDao uRoleDao;

    @Autowired
	private UserService userService;

    //登陆验证，这里方便url测试，正式上线需要使用POST方式提交
    @RequestMapping(value = "/ajaxLogin",method= RequestMethod.POST)
	@ResponseBody
    public Map<String,Object> index(UUser user) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
    	if (user.getUsername() != null && user.getPswd() != null) {
        	//封装用户数据
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPswd(), "login");
            Subject currentUser = SecurityUtils.getSubject();//获取subject
            logger.info("对用户[" + user.getUsername() + "]进行登录验证..验证开始");
            try {
            	//执行登录方法
                currentUser.login( token );
                //验证是否登录成功
                if (currentUser.isAuthenticated()) {
                    logger.info("用户[" + user.getUsername() + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
					resultMap.put("status", 200);
					resultMap.put("username", user.getUsername());
					resultMap.put("message", "登录成功");
					UUser uUser = (UUser)currentUser.getPrincipal();
					uUser.setLastLoginTime(new Date());
					userService.updateLastLoginTime(uUser);
                } else {
					logger.info("用户[" + user.getUsername() + "]登录认证失败,重新登陆");
					token.clear();
                }
            } catch (Exception e) {
				resultMap.put("status", 500);
				resultMap.put("message", "用户名或密码错误");
			}
        }
        return resultMap;
    }


    @Autowired
	private RoleService roleService;

	/**
	 * 查询用户级别
	 * @return
	 */
	@RequestMapping("/getRoleGrade")
    public String getRoleGrade(){
		return roleService.getRoleGrade() ;
	}

	@RequestMapping("/addUnitId")
	public void addUnitId(){
		try {
			userService.addUnitId();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@RequestMapping("/user/addPersonUser")
	public void addPersonUser(){
		try {
			userService.addPersonUser();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 分页条件查询用户
	 * 	admin和省卫计委可以查询所有的用户
	 * 	市卫生局查询本市的用户
	 * 	单位查询本单位的用户
	 * 	个人无此功能
	 */
	@RequestMapping("/user/search")
	public PageResult search(@RequestBody UUser user ,int page, int rows){
		try {
			return userService.search(user, page, rows);
		}catch (Exception e){
			logger.info("查询用户失败");
			e.printStackTrace();
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
	@RequestMapping("/user/addUser")
	public String addUser(@RequestBody UUser user,Integer role){
		try {
			return userService.addUser(user, role);
		}catch (Exception e){
			e.printStackTrace();
			return "新增用户失败";
		}
	}
	/**
	 * 单位管理员修改用户
	 *
	 */
	@RequestMapping("/user/update")
	public String update(@RequestBody UUser user){
		try {
			return userService.update(user);
		}catch (Exception e){
			e.printStackTrace();
			return "修改用户失败";
		}
	}
	/**
	 * 单位管理员删除用户
	 */
	@RequestMapping("/user/delete")
	public Result delete(@RequestBody Integer[] ids){
		try {
			userService.delete(ids);
			return new Result(true,"删除用户成功");
		}catch (Exception e){
			e.printStackTrace();
			return new Result(false,"删除用户失败");
		}
	}
	/**
	 * 查询用户和角色
	 */
	@RequestMapping("/user/selectUserAndRole")
	public UUser selectUserAndRole(){
		try {
			return userService.selectUserAndRole();
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}

