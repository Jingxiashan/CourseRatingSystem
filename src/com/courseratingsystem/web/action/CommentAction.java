package com.courseratingsystem.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Comment;
import com.courseratingsystem.web.service.CommentService;
import com.courseratingsystem.web.vo.CommentPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommentAction extends ActionSupport implements ModelDriven<Comment>{
	private int currentPage=1;
	private int pageSize=5;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	private Comment comment = new Comment();
	private CommentService commentService;
	private String sortmethod;
	
	public String findByTeacher(){
		CommentPage commentPage = commentService.findCommentByTeacherID(comment.getTeacher().getTeacherid(),currentPage,pageSize);
		if(commentPage.getTotalCount()>0){
			commentService.sorting(commentPage.getcommentList(), sortmethod);
			ServletActionContext.getRequest().setAttribute("commentPage", commentPage);
			return SUCCESS;
		}
		return "fail";
	}
	
	public String findByCourse(){
		CommentPage commentPage = commentService.findCommentByCourseID(comment.getCourse().getCourseid(),currentPage,pageSize);
		if(commentPage.getTotalCount()>0){
			commentService.sorting(commentPage.getcommentList(), sortmethod);
			ServletActionContext.getRequest().setAttribute("commentPage", commentPage);
			return SUCCESS;
		}
		return "fail";
	}
	
	public String findByUser(){
		CommentPage commentPage = commentService.findCommentByUserID(comment.getUser().getUserid(),currentPage,pageSize);
		if(commentPage.getTotalCount()>0){
			commentService.sorting(commentPage.getcommentList(), sortmethod);
			ServletActionContext.getRequest().setAttribute("commentPage", commentPage);
			return SUCCESS;
		}
		return "fail";
	}
	
	public String addComment(){
		commentService.add(comment);
		return SUCCESS;
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
