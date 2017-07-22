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
	private static final String MSG_REGISTER_FAILED_DUPLICATE = "用户名已存在，请重试";
	private static final String MSG_REGISTER_USERNAME_AVAILABLE = "哈哈哈哈，用户名可以用。";
	private static final String MSG_REGISTER_ERROR = "出现未知错误，请重试";
	private static final String FAIL = "fail";
	
	public String checkUsername() {
		String tmpUsername = ServletActionContext.getRequest().getParameter("username");
		if(logininfoService.findLogininfoByusername(tmpUsername) != null) {
			//已经存在相同的用户名
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
			//先在UserService里面注册，获得user
			User tmpUser = userService.register(registerInfo.getUser());
			//然后在LoginService里面注册
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
