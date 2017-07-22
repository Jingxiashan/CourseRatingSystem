package com.courseratingsystem.web.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.LogininfoService;
import com.courseratingsystem.web.service.UserService;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

class RegisterInfo{
	String username;
	String password;
	String nickname;
	String grade;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public User getUser() {
		User user = new User();
		user.setNickname(nickname);
		user.setGrade(grade);
		return user;
	}
}
public class RegisterAction extends ActionSupport implements ModelDriven<RegisterInfo>{
	RegisterInfo registerInfo = new RegisterInfo();
	LogininfoService logininfoService;
	String result;
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	UserService userService;
	private static final String MSG_REGISTER_FAILED_DUPLICATE = "�û����Ѵ��ڣ�������";
	private static final String MSG_REGISTER_USERNAME_AVAILABLE = "�����������û��������á�";
	private static final String MSG_REGISTER_ERROR = "����δ֪����������";
	private static final String FAIL = "fail";
	
	public String checkUsername() {
		String tmpUsername = ServletActionContext.getRequest().getParameter("username");
		if(logininfoService.findLogininfoByusername(tmpUsername) != null) {
			//�Ѿ�������ͬ���û���
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("result", FAIL);
			map.put("message", MSG_REGISTER_FAILED_DUPLICATE);
			result = JSON.toJSONString(map);
			return FAIL;
		}else {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("result", SUCCESS);
			map.put("message", MSG_REGISTER_USERNAME_AVAILABLE);
			result = JSON.toJSONString(map);
			return SUCCESS;
		}
	}
	
	public String register() {
			//����UserService����ע�ᣬ���user
			User tmpUser = userService.register(registerInfo.getUser());
			//Ȼ����LoginService����ע��
			logininfoService.register(tmpUser, registerInfo.getUsername(), registerInfo.getPassword());
			ServletActionContext.getRequest().getSession().setAttribute("user", tmpUser);
			result = SUCCESS; 
			return SUCCESS;
	}
	
	@Override
	public RegisterInfo getModel() {
		return registerInfo;
	}
}
