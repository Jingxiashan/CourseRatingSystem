package com.courseratingsystem.web.action;

import com.courseratingsystem.web.service.LogininfoService;
import com.courseratingsystem.web.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

class RegisterInfo{
	
}
public class RegisterAction extends ActionSupport implements ModelDriven<RegisterInfo>{
	RegisterInfo registerInfo = new RegisterInfo();
	LogininfoService logininfoService;
	UserService userService;
	
	public String execute() {
		return null;
	}
	
	@Override
	public RegisterInfo getModel() {
		return registerInfo;
	}
}
