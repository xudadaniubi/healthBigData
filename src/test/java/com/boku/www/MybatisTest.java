package com.boku.www;

import com.boku.www.mapper.UserMapper;
import com.boku.www.pojo.TUser;
import com.boku.www.pojo.User;
import com.boku.www.service.ExcelImportService;
import com.boku.www.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        List<User> users = userMapper.queryUserList();
        System.out.println(users);
    }
	@Autowired
	private UserService userService;
	@Test
	public void test2(){
		TUser user = userService.getUser("1");
		System.out.println(user);
	}

	@Autowired
	private ExcelImportService excelImportService;
	@Test
	public void test3() throws Exception {

		String filePath = "E:\\healthybigdata\\项目数据表.xls";
		File file = new File(filePath);

		//InputStream inputStream = new FileInputStream(filePath);
		//System.out.println(filePath);
		//截取字符串名称
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
		System.out.println(fileName);
		String message = excelImportService.importExcel(file, fileName);
		System.out.println(message);

	}
}
