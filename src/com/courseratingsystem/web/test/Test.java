package com.courseratingsystem.web.test;

import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.service.LogininfoService;
import com.courseratingsystem.web.service.impl.LogininfoServiceImpl;

public class Test {

	public static void main(String[] args) {
		LogininfoService logininfoService = new LogininfoServiceImpl();
		Logininfo newlogininfo= new Logininfo();
		newlogininfo.setUsername("kk");
		logininfoService.delete(newlogininfo);
//		Logininfo logininfo = logininfoService.findLogininfoByusernameandpassword("ludi", "123");
//		logininfo.setPassword("000");
//		logininfoService.update(logininfo);
		System.out.println("运行成功。。。");
	}

}
