package com.boku.www.config;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置项
 * Created by Lucare.Feng on 2017/3/6.
 *
 *
 ApplicationCode 用户编写代码
 Subject 就是 shiro 管理的用户
 SecurityManager 安全管理器，是 shiro 权限控制核心对象， 在编程时，只需要操作
 Subject 方法， 底层调用 SecurityManager 方法，无需直接编程操作 SecurityManager
 Realm 应用程序和安全数据之间连接器 ，应用程序 进行权限控制读取安全数据（数据
 表、文件、网路 … ），通过 Realm 对象完成
 登录流程： 应用程序 --- Subject --- SecurityManager --- Realm --- 安全数据
 */
@Configuration
@CrossOrigin//解决跨域问题
public class ShiroConfiguration {

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	//处理认证匹配处理器：如果自定义需要实现继承HashedCredentialsMatcher
	//指定加密方式方式，也可以在这里加入缓存，当用户超过五次登陆错误就锁定该用户禁止不断尝试登陆
//    @Bean(name = "hashedCredentialsMatcher")
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
//        credentialsMatcher.setHashAlgorithmName("MD5");
//        credentialsMatcher.setHashIterations(2);
//        credentialsMatcher.setStoredCredentialsHexEncoded(true);
//        return credentialsMatcher;
//    }

	@Bean(name = "shiroRealm")
	@DependsOn("lifecycleBeanPostProcessor")
	public ShiroRealm shiroRealm() {
		ShiroRealm realm = new ShiroRealm();
//        realm.setCredentialsMatcher(hashedCredentialsMatcher());
		return realm;
	}

	@Bean(name = "ehCacheManager")
	@DependsOn("lifecycleBeanPostProcessor")
	public EhCacheManager ehCacheManager(){
		EhCacheManager ehCacheManager = new EhCacheManager();
		return ehCacheManager;
	}

	@Bean(name = "securityManager")
	//安全管理器
	public DefaultWebSecurityManager securityManager(){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(shiroRealm());
		securityManager.setCacheManager(ehCacheManager());//用户授权/认证信息Cache, 采用EhCache 缓存
		return securityManager;
	}

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager  securityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);//设置安全管理器
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		//anon 未认证可以访问
		//authc 认证后可以访问
		//perms 需要特定权限才能访问
		//roles 需要特定角色才能访问
		//user 需要特定用户才能访问
		Map<String, String> filterChainDefinitionManager = new LinkedHashMap();
		filterChainDefinitionManager.put("/logout", "logout");

        /*filterChainDefinitionManager.put("/user/**", "authc,roles[user]");//必须认证才能访问
        filterChainDefinitionManager.put("/shop/**", "authc,roles[shop]");
        filterChainDefinitionManager.put("/admin/**", "authc,roles[admin]");
        //需要特定的权限才能访问
		filterChainDefinitionManager.put("/admin/**", "perms[admin]");*/
		filterChainDefinitionManager.put("/login", "anon");//anon 可以理解为不拦截
		filterChainDefinitionManager.put("/file/downloadTemplateProjectDataExcel", "anon");
		filterChainDefinitionManager.put("/file/downloadTemplateThesisForChineseExcel", "anon");
		filterChainDefinitionManager.put("/file/downloadTemplateThesisForEnglishExcel", "anon");
		filterChainDefinitionManager.put("/file/downloadTemplatePatentExcel", "anon");
		filterChainDefinitionManager.put("/projectData/findAll", "anon");//anon 可以理解为不拦截
		filterChainDefinitionManager.put("/thesisForChinese/countTheNumberOfThesisForChineseInEachArea", "anon");
		filterChainDefinitionManager.put("/ajaxLogin", "anon");//anon 可以理解为不拦截
		filterChainDefinitionManager.put("/fileUpload", "anon");//anon 可以理解为不拦截
		filterChainDefinitionManager.put("/statistic/**",  "anon");//静态资源不拦截
		//filterChainDefinitionManager.put("/**",  "authc");//认证后可以访问所有页面		原数据：其他资源全部拦截"authc,roles[user]"
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionManager);
		shiroFilterFactoryBean.setLoginUrl("/login");//设置未登录跳转页面
		shiroFilterFactoryBean.setSuccessUrl("/");//登录成功提示页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");//未授权提示页面

		return shiroFilterFactoryBean;
	}

	@Bean
	@ConditionalOnMissingBean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
		daap.setProxyTargetClass(true);
		return daap;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(securityManager);
		return aasa;
	}


}
