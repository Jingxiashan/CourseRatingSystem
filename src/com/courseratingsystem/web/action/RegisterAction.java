package com.courseratingsystem.web.action;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.LogininfoService;
import com.courseratingsystem.web.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

class RegisterInfo{
	String username;
	String password1;
	String password2;
	String nickname;
	String grade;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
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
	private static final String MSG_REGISTER_FAILED_INCONSISTANT = "�����������벻һ�£�������";
	private static final String MSG_REGISTER_FAILED_EMPTY = "����Ϊ�գ�������";
	private static final String MSG_REGISTER_ERROR = "����δ֪����������";
	private static final String FAIL = "fail";
	
	public String execute() {
		if(registerInfo.getUsername().isEmpty()) {
			ServletActionContext.getRequest().setAttribute("message", "�û���"+MSG_REGISTER_FAILED_EMPTY);
			return FAIL;			
		}else if(registerInfo.getNickname().isEmpty()) {
			ServletActionContext.getRequest().setAttribute("message", "�ǳ�"+MSG_REGISTER_FAILED_EMPTY);
			return FAIL;						
		}else if(registerInfo.getGrade().isEmpty()) {
			ServletActionContext.getRequest().setAttribute("message", "�꼶"+MSG_REGISTER_FAILED_EMPTY);
			return FAIL;						
		}else if(!registerInfo.getPassword1().equals(registerInfo.getPassword2())) {
			//�����������벻һ�£�ע��ʧ��
			ServletActionContext.getRequest().setAttribute("message", MSG_REGISTER_FAILED_INCONSISTANT);
			return FAIL;
		}else if(registerInfo.getPassword1().isEmpty() && registerInfo.getPassword2().isEmpty()) {
			ServletActionContext.getRequest().setAttribute("message", "����"+MSG_REGISTER_FAILED_EMPTY);
			return FAIL;						
		}else if(logininfoService.findLogininfoByusername(registerInfo.getUsername()) != null) {
			//�Ѿ�������ͬ���û�����ע��ʧ��
			ServletActionContext.getRequest().setAttribute("message", MSG_REGISTER_FAILED_DUPLICATE);
			return FAIL; 
		}else{
			//����ע�Ṥ��
			//����UserService����ע�ᣬ���user
			User tmpUser = userService.register(registerInfo.getUser());
			//Ȼ����LoginService����ע��
			logininfoService.register(tmpUser, registerInfo.getUsername(), registerInfo.getPassword1());
			ServletActionContext.getRequest().getSession().setAttribute("user", tmpUser);
			return SUCCESS;
		}
	}
	
	@Override
	public RegisterInfo getModel() {
		return registerInfo;
	}
}
