package com.courseratingsystem.web.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.CommentService;
import com.courseratingsystem.web.service.CourseService;
import com.courseratingsystem.web.service.UserService;
import com.courseratingsystem.web.service.impl.CommentServiceImpl;
import com.courseratingsystem.web.vo.CommentPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private int currentPage = 1;
	private final int pageSize = 10;
	private int commentid;
	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	User user = new User();
	UserService userService;
	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	CommentService commentService;
	CourseService courseService;
	private static final String FAIL = "fail";
	
	public String modifyProfile(){
		User currentUser =	(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		currentUser.setGrade(user.getGrade());
		currentUser.setNickname(user.getNickname());
		currentUser.setWechatAccount(user.getWechatAccount());
		currentUser.setIntroduction(user.getIntroduction());
		userService.update(currentUser);
		//最后 更新session里面的user
		ServletActionContext.getRequest().getSession().setAttribute("user", currentUser);
		return SUCCESS;
	}
	
	public String getSelfProfile(){
		User currentUser =	(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		//personal page is saved in session.user
		/*
		//get comments
		CommentPage commentPage = commentService.findCommentByUserID(currentUser.getUserid(), currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("commentPage", commentPage);
		*/
		//get favorites
		List<Course> favourateList = userService.findFavouratesById(currentUser.getUserid());
		ServletActionContext.getRequest().setAttribute("favourateList", favourateList);
		return SUCCESS;
	}
	
	public String getOthersProfile(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String str_userid = ServletActionContext.getRequest().getParameter("userid");
		if(str_userid != null) {
			int userid = Integer.parseInt(ServletActionContext.getRequest().getParameter("userid"));
			//save user in request
			User userToShow =	userService.findUserById(userid);
			ServletActionContext.getRequest().setAttribute("user", userToShow);

			//get comments
			CommentPage commentPage = commentService.findCommentByUserID(userToShow.getUserid(), currentPage, pageSize, CommentServiceImpl.COMMENT_SORT_METHOD_BYLIKECOUNT);
			ServletActionContext.getRequest().setAttribute("commentPage", commentPage);

			return SUCCESS;
		}else return FAIL;		
	}
	
	public String addFavourate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String str_courseid = request.getParameter("courseid");
		if(str_courseid != null) {
			int courseid = Integer.parseInt(str_courseid);
			User currentUser =	(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			userService.addFavourateCourse(currentUser.getUserid(), courseService.findCourseById(courseid));
			return SUCCESS;	
		}else return FAIL;
		
	}
	
	public String deleteFavourate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String str_courseid = request.getParameter("courseid");
		if(str_courseid != null) {
			int courseid = Integer.parseInt(str_courseid);
			User currentUser =	(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			userService.deleteFavourateCourse(currentUser.getUserid(), courseService.findCourseById(courseid));
			return SUCCESS;	
		}else return FAIL;
		
	}
	
	public String deleteComment() {
		return null;
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
