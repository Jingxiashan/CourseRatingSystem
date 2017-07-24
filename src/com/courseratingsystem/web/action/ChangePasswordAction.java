package com.courseratingsystem.web.action;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.LogininfoService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

class ModifyPassword {
	private int userid;
	private String oldPassword;
	private String newPassword;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}

public class ChangePasswordAction extends ActionSupport implements ModelDriven<ModifyPassword> {
	ModifyPassword modifier = new ModifyPassword();
	private static final String MSG_MODIFYPASS_FAILED_EMPTY = "新密码不能为空，请重试";
	private static final String MSG_MODIFYPASS_FAILED_WRONGPASS = "原密码不正确，请重试";
	private static final String FAIL = "fail";
	LogininfoService logininfoService;
	String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String execute() {
		//进行修改密码
		boolean changeResult = logininfoService.changepassword(modifier.getUserid(), modifier.getOldPassword(),
				modifier.getNewPassword());
		if(changeResult) {
			//修改成功
			result = SUCCESS;
			return SUCCESS;
		}else {
			//原密码不正确，修改失败
			//ServletActionContext.getRequest().setAttribute("message", MSG_MODIFYPASS_FAILED_WRONGPASS);
			result = MSG_MODIFYPASS_FAILED_WRONGPASS;
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
	public ModifyPassword getModel() {
		return modifier;
	}

}
