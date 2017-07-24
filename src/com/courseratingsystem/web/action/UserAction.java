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
	private String result;
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	private static final String GET_TO_SELF_PROFILE = "get_to_self_profile";
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
		//��� ����session�����user
		ServletActionContext.getRequest().getSession().setAttribute("user", currentUser);
		result = SUCCESS;
		return SUCCESS;
	}

	
	public String getOthersProfile(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String str_userid = request.getParameter("userid");
		if(str_userid != null) {
			int userid = Integer.parseInt(str_userid);
			if(request.getSession().getAttribute("user") != null){
				if(userid == ((User)request.getSession().getAttribute("user")).getUserid()){
					return GET_TO_SELF_PROFILE;
				}	
			}
			
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
			ServletActionContext.getRequest().getSession().setAttribute("user", userService.findUserById(currentUser.getUserid()));
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
			ServletActionContext.getRequest().getSession().setAttribute("user", userService.findUserById(currentUser.getUserid()));
			return SUCCESS;	
		}else return FAIL;
		
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
