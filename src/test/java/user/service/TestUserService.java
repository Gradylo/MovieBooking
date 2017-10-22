package user.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.mb.user.entity.User;
import cn.tedu.mb.user.service.UserService;
import cn.tedu.mb.user.service.impl.UserServiceImpl;

public class TestUserService {
	ClassPathXmlApplicationContext ctx;
	UserService UserService;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-mybatis.xml");
		UserService=ctx.getBean("UserServiceImpl",UserServiceImpl.class);
	}
	
	@After
	public void destory(){
		ctx.close();
	}
	
	@Test
	public void TestaddUser(){
		User user=new User();
		user.setName("lzp");
		user.setUsername("lzp2");
		user.setPassword("123456");
		user.setPhone("12345678910");
		int result=UserService.regUser(user);
		System.out.println(result);
	}
	
	@Test
	public void TestdoLogin(){
		User user=UserService.doLogin("", "123456");
		System.out.println(user);
	}
	
}
