package com.courseratingsystem.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Comment;
import com.courseratingsystem.web.service.CommentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommentAction extends ActionSupport implements ModelDriven<Comment>{
	Comment comment = new Comment();
	CommentService commentService;
	private String sortmethod;
	
	public String findByBeacher(){
		List<Comment> commentList = commentService.findCommentByTeacherID(comment.getTeacher().getTeacherid());
		if(!commentList.isEmpty()){
			commentService.sorting(commentList, sortmethod);
			ServletActionContext.getRequest().setAttribute("commentList", commentList);
			return SUCCESS;
		}
		return "fail";
	}
	
	public String findByCourse(){
		List<Comment> commentList = commentService.findCommentByCourseID(comment.getCourse().getCourseid());
		if(!commentList.isEmpty()){
			commentService.sorting(commentList, sortmethod);
			ServletActionContext.getRequest().setAttribute("commentList", commentList);
			return SUCCESS;
		}
		return "fail";
	}
	
	public String findByUser(){
		List<Comment> commentList = commentService.findCommentByUserID(comment.getUser().getUserid());
		if(!commentList.isEmpty()){
			commentService.sorting(commentList, sortmethod);
			ServletActionContext.getRequest().setAttribute("commentList", commentList);
			return SUCCESS;
		}
		return "fail";
	}
	
	public CommentService getCommentService(){
		return commentService;
	}
	
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@Override
	public Comment getModel() {
		return comment;
	}
}
