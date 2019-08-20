package com.boku.www.config;


import com.boku.www.mapper.system.UPermissionDao;
import com.boku.www.mapper.system.URoleDao;
import com.boku.www.mapper.system.UUserDao;
import com.boku.www.pojo.system.UPermission;
import com.boku.www.pojo.system.URole;
import com.boku.www.pojo.system.UUser;
import com.boku.www.service.system.PermissionService;
import com.boku.www.service.system.RoleService;
import com.boku.www.service.system.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * 获取用户的角色和权限信息
 * Created by bamboo on 2017/5/10.
 */
public class ShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    //一般这里都写的是servic，我省略了service的接口和实现方法直接调用的dao
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 登录认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //转换token
    	UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("验证当前Subject时获取到token为：" + token.toString());
        //查出是否有此用户
        UUser hasUser = userService.findByName(token.getUsername());
		//String md5Pwd = new Md5Hash(token.getPassword(), "lucare",2).toString();
		/*System.out.println("token.getPassword()"+token.getPassword());
		System.out.println("md5Pwd"+md5Pwd);*/
        if (hasUser != null) {
            // 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
            List<URole> rlist = roleService.findRoleByUid(hasUser.getId());//获取用户角色
            //List<UPermission> plist = permissionService.findPermissionByUid(hasUser.getId());//获取用户权限
            List<String> roleStrlist=new ArrayList<String>();////用户的角色集合
            //List<String> perminsStrlist=new ArrayList<String>();//用户的权限集合
            for (URole role : rlist) {
            	roleStrlist.add(role.getName());
            }
            //这里需要判空
            /*for (UPermission uPermission : plist) {
            	perminsStrlist.add(uPermission.getName());
			}*/
            hasUser.setRoleStrlist(roleStrlist);
            //hasUser.setPerminsStrlist(perminsStrlist);
//            Session session = SecurityUtils.getSubject().getSession();
//            session.setAttribute("user", hasUser);//成功则放入session
			/**
			 * 四个参数
			 * hasUser：认证的实体信息，可以是username，也可以是数据库表对应的用户的实体对象
			 * hasUser.getPswd()：数据库中的密码（经过加密的密码）
			 * salt：盐值（使用用户名）
			 * realmName：当前realm对象的name，调用父类的getName()方法即可
			 */
			// 获取盐值，即用户名
			ByteSource salt = ByteSource.Util.bytes(hasUser.getUsername());
			String realmName = this.getName();
			// 将用户，密码，盐值，realmName实例化到SimpleAuthenticationInfo中交给Shiro来管理
			return new SimpleAuthenticationInfo(hasUser, hasUser.getPswd(), salt,realmName);
			//return new SimpleAuthenticationInfo(hasUser, hasUser.getPswd(), getName());//添加资源的授权字符串
        }
        return null;
    }

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("##################执行Shiro权限认证##################");
        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
//        String loginName = (String) super.getAvailablePrincipal(principalCollection);
        UUser user = (UUser) principalCollection.getPrimaryPrincipal();
//        //到数据库查是否有此对象
//        User user = null;// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        user = userMapper.findByName(loginName);
        if (user != null) {
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //用户的角色集合
            info.addRoles(user.getRoleStrlist()); 
            //用户的权限集合
            //info.addStringPermissions(user.getPerminsStrlist());

            return info;
        }
        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
        return null;
    }
}
