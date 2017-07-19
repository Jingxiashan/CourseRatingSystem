package com.courseratingsystem.web.action;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.service.LogininfoService;
import com.courseratingsystem.web.service.impl.LogininfoServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Logininfo>{
	Logininfo logininfo;
	LogininfoService logininfoService;
	private static final String LOGIN_FAILED = "用户名或密码错误，请重试";
	private static final String LOGIN_ERROR = "出现未知错误，请重试";
	
	
	public String execute() {
		String result = logininfoService.login(logininfo);
		if(result.equals(SUCCESS)) {
			//LOGIN SUCCESS
			return SUCCESS;
		}else if(result.equals("fail")){
			//LOGIN FAILED
			ServletActionContext.getRequest().setAttribute("message", LOGIN_FAILED);
			return "fail";
		}else {
			ServletActionContext.getRequest().setAttribute("message", LOGIN_ERROR);
			return ERROR;
		}
	}

	public LogininfoService getLogininfoService() {
		return logininfoService;
	}

	public void setLogininfoService(LogininfoService logininfoService) {
		this.logininfoService = logininfoService;
	}

	@Override
	public Logininfo getModel() {
		return logininfo;
	}
}
