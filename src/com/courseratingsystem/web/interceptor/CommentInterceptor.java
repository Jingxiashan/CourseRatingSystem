package com.courseratingsystem.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.action.CommentAction;
import com.courseratingsystem.web.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CommentInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user==null){
			CommentAction action =(CommentAction) invocation.getAction();
			ServletActionContext.getRequest().setAttribute("message", "请老司机您先上车哦");
			return "fail";
		}
		return invocation.invoke();
	}

}
