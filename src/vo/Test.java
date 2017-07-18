package com.chinasoft.app.vo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chinasoft.app.service.UserService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService=(UserService) app.getBean("userService");
		userService.sayHello();

	}

}
