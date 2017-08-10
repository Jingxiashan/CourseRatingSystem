package com.courseratingsystem.web.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.alibaba.fastjson.JSON;
import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.LogininfoService;
import com.courseratingsystem.web.service.UserService;
import com.courseratingsystem.web.service.impl.LogininfoServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserApi extends ActionSupport{
	public static final String STR_RESULT_CODE = "result_code";
	public static final String STR_REASON = "reason";
	public static final String STR_RESULT = "result";
	public static final int RESULT_CODE_OK = 200;
	public static final int RESULT_CODE_BAD_REQUEST = 400;
			
	private static final String MSG_LOGIN_FAILED = "用户名或密码错误，请重试";
	private static final String MSG_LOGIN_ERROR = "出现未知错误，请重试";
	private static final String MSG_REGISTER_FAILED_DUPLICATE = "用户名已存在，换一个试试吧";
	private static final String MSG_GETUSER_FAILED_NOT_EXISTS = "不存在当前用户";
	private static final String FAIL = "fail";
	Map<String,Object> resultMap;
	Map<String,Object> returnMap;
	private Object returnJson;
	private LogininfoService logininfoService;
	private UserService userService;
	



	public Object getReturnJson() {
		return returnJson;
	}

	public void setReturnJson(Object returnJson) {
		this.returnJson = returnJson;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public LogininfoService getLogininfoService() {
		return logininfoService;
	}

	public void setLogininfoService(LogininfoService logininfoService) {
		this.logininfoService = logininfoService;
	}


	
	public String login() {
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Logininfo logininfo = new Logininfo();
		logininfo.setUsername(username);
		logininfo.setPassword(password);
		User tmpUser = logininfoService.login(logininfo);
		if(tmpUser != null) {
			//登陆成功
			resultMap.put("userid", tmpUser.getUserid());
			returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
			returnMap.put(STR_REASON, SUCCESS);
			returnMap.put(STR_RESULT, resultMap);
			returnJson = JSON.toJSON(returnMap);
		}else{
			//用户名或密码错误，登陆失败
			returnMap.put(STR_RESULT_CODE, RESULT_CODE_BAD_REQUEST);
			returnMap.put(STR_REASON, MSG_LOGIN_FAILED);
			returnJson = JSON.toJSON(returnMap);
		}
		return SUCCESS;
	}
	
	public String register() {
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String grade = request.getParameter("grade");
		if(logininfoService.findLogininfoByusername(username) != null) {
			//已经存在相同的用户名
			returnMap.put(STR_RESULT_CODE, RESULT_CODE_BAD_REQUEST);
			returnMap.put(STR_REASON, MSG_REGISTER_FAILED_DUPLICATE);
			returnJson = JSON.toJSON(returnMap);
		}else {
			//用户名可以注册
			//先在UserService里面注册，获得user
			User tmpUser = userService.register(new User(nickname,grade));
			//然后在LoginService里面注册
			logininfoService.register(tmpUser, username, password);
			resultMap.put("userid", tmpUser.getUserid());
			returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
			returnMap.put(STR_REASON, SUCCESS);
			returnMap.put(STR_RESULT, resultMap);
			returnJson = JSON.toJSON(returnMap);
		}
		return SUCCESS;
	}
	
	public String getUser() {
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String str_userid = request.getParameter("userid");
		if(str_userid != null) {
			int userid = Integer.parseInt(str_userid);
			User tmpUser = userService.findUserById(userid);
			if(tmpUser != null) {
				//存在当前用户
				resultMap.put("nickname", tmpUser.getNickname());
				resultMap.put("grade", tmpUser.getGrade());
				resultMap.put("wechat", tmpUser.getWechatAccount());
				resultMap.put("intro", tmpUser.getIntroduction());
				resultMap.put("picpath", tmpUser.getPicpath());
				returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
				returnMap.put(STR_REASON, SUCCESS);
				returnMap.put(STR_RESULT, resultMap);
				returnJson = JSON.toJSON(returnMap);
			}else {
				//不存在当前用户
				returnMap.put(STR_RESULT_CODE, RESULT_CODE_BAD_REQUEST);
				returnMap.put(STR_REASON, MSG_GETUSER_FAILED_NOT_EXISTS);
				returnJson = JSON.toJSON(returnMap);
			}
		}
		return SUCCESS;
	}
	
}
