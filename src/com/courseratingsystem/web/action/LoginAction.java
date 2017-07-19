package com.courseratingsystem.web.action;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.LogininfoService;
import com.courseratingsystem.web.service.impl.LogininfoServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Logininfo>{
	Logininfo logininfo = new Logininfo();
	LogininfoService logininfoService;
	private static final String MSG_LOGIN_FAILED = "用户名或密码错误，请重试";
	private static final String MSG_LOGIN_ERROR = "出现未知错误，请重试";
	private static final String FAIL = "fail";
	
	
	public String execute() {
		User result = logininfoService.login(logininfo);
		if(result != null) {
			//登陆成功
			ServletActionContext.getRequest().getSession().setAttribute("user", result);
			return SUCCESS;
		}else{
			//用户名或密码错误，登陆失败
			ServletActionContext.getRequest().setAttribute("message", MSG_LOGIN_FAILED);
			return FAIL;
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
