package com.courseratingsystem.web.action;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.LogininfoService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

class ModifyPassword {
	private int userid;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	private String oldPassword;
	private String newPassword1;
	private String newPassword2;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword1() {
		return newPassword1;
	}

	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}

	public String getNewPassword2() {
		return newPassword2;
	}

	public void setNewPassword2(String newPassword2) {
		this.newPassword2 = newPassword2;
	}
}

public class ChangePasswordAction extends ActionSupport implements ModelDriven<ModifyPassword> {
	ModifyPassword modifier = new ModifyPassword();
	private static final String MSG_MODIFYPASS_FAILED_EMPTY = "新密码不能为空，请重试";
	private static final String MSG_MODIFYPASS_FAILED_INCONSISTANT = "两次密码输入不一致，请重试";
	private static final String MSG_MODIFYPASS_FAILED_WRONGPASS = "原密码不正确，请重试";
	private static final String FAIL = "fail";
	LogininfoService logininfoService;

	public String execute() {
		if(!modifier.getNewPassword1().equals(modifier.getNewPassword2())) {
			//两次密码输入不一致
			ServletActionContext.getRequest().setAttribute("message", MSG_MODIFYPASS_FAILED_INCONSISTANT);
			return FAIL; 			
		}else if(modifier.getNewPassword1().isEmpty()) {
			//密码为空
			ServletActionContext.getRequest().setAttribute("message", MSG_MODIFYPASS_FAILED_EMPTY);
			return FAIL; 
		}else{
			//进行修改密码
			boolean result = logininfoService.changepassword(modifier.getUserid(), modifier.getOldPassword(),
					modifier.getNewPassword1());
			if(result) {
				//修改成功
				return SUCCESS;
			}else {
				//原密码不正确，修改失败
				ServletActionContext.getRequest().setAttribute("message", MSG_MODIFYPASS_FAILED_WRONGPASS);
				return FAIL; 
			}
		}
	}

	public LogininfoService getLogininfoService() {
		return logininfoService;
	}

	public void setLogininfoService(LogininfoService logininfoService) {
		this.logininfoService = logininfoService;
	}

	@Override
	public ModifyPassword getModel() {
		return modifier;
	}

}
