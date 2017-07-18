package com.courseratingsystem.web.action;

import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.service.LogininfoService;
import com.courseratingsystem.web.service.impl.LogininfoServiceImpl;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction implements ModelDriven<Logininfo>{
	Logininfo logininfo;
	LogininfoService logininfoService;
	public void execute() {
		String result = logininfoService.login(logininfo);
		if(result.equals("success")) {
			//LOGIN SUCCESS
			
		}else {
			//LOGIN FAILED
			
		}
	}

	@Override
	public Logininfo getModel() {
		return logininfo;
	}
}
