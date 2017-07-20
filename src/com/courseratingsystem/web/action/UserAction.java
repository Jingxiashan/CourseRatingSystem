package com.courseratingsystem.web.action;


import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.CommentService;
import com.courseratingsystem.web.service.UserService;
import com.courseratingsystem.web.vo.CommentPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private int currentPage = 1;
	private final int pageSize = 10;
	private int courseid;
	private int userid;
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	User user = new User();
	UserService userService;
	CommentService commentService;
	
	public String modifyProfile(){
		
		//最后 更新session里面的user
		ServletActionContext.getRequest().getSession().setAttribute("user", user);
		return null;
	}
	
	public String getSelfProfile(){
		User currentUser =	(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		//personal page is saved in session.user
		//get comments
		CommentPage commentPage = commentService.findCommentByUserID(currentUser.getUserid(), currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("commentPage", commentPage);
		return SUCCESS;
	}
	
	public String getOthersProfile(){
		User currentUser =	(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		//personal page is saved in session.user
		//get comments
		CommentPage commentPage = commentService.findCommentByUserID(currentUser.getUserid(), currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("commentPage", commentPage);
		return SUCCESS;
	}
	
	public String addFavourate(){
		User currentUser =	(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		//personal page is saved in session.user
		//get comments
		CommentPage commentPage = commentService.findCommentByUserID(currentUser.getUserid(), currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("commentPage", commentPage);
		return SUCCESS;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@Override
	public User getModel() {
		return user;
	}

}
