package com.courseratingsystem.web.action;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONObject;
import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.LogininfoService;
import com.courseratingsystem.web.service.impl.LogininfoServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<Logininfo>{
	Logininfo logininfo = new Logininfo();
	LogininfoService logininfoService;
	String result;
	private static final String MSG_LOGIN_FAILED = "�û������������������";
	private static final String MSG_LOGIN_ERROR = "����δ֪����������";
	private static final String FAIL = "fail";
	
	
	public String execute() {
		User resultUser = logininfoService.login(logininfo);
		if(resultUser != null) {
			//��½�ɹ�
			result = SUCCESS;
			ServletActionContext.getRequest().getSession().setAttribute("user", resultUser);
			return SUCCESS;
		}else{
			//�û�����������󣬵�½ʧ��
			result = MSG_LOGIN_FAILED;
			//ServletActionContext.getRequest().setAttribute("message", MSG_LOGIN_FAILED);
			return FAIL;
		}
	}
	
	public String logout() {
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return SUCCESS;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
