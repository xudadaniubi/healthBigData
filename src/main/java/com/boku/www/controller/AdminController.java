package com.boku.www.controller;

import com.boku.www.mapper.system.URoleDao;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.system.RoleService;
import com.boku.www.service.system.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    
    
    /**
     * ajax登录请求接口方式登陆
     * @param username
     * @param password
     * @return
     */
    /*@RequestMapping(value="/ajaxLogin",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> submitLogin(String username, String password,Model model) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try {

        	UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(token);
            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");

        } catch (Exception e) {
            resultMap.put("status", 500);
            resultMap.put("message", e.getMessage());
        }
        return resultMap;
    }*/

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
}

