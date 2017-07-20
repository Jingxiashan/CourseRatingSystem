package com.courseratingsystem.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Comment;
import com.courseratingsystem.web.domain.CourseOverview;
import com.courseratingsystem.web.service.CommentService;
import com.courseratingsystem.web.service.impl.CommentServiceImpl;
import com.courseratingsystem.web.vo.CommentPage;
import com.courseratingsystem.web.vo.CoursePage;
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
	
	private String sortmethod=CommentServiceImpl.COMMENT_SORT_METHOD_BYLIKECOUNT;

	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}	
	public String getSortmethod() {
		return sortmethod;
	}
	public void setSortmethod(String sortmethod) {
		this.sortmethod = sortmethod;
	}
	
	public String findByTeacher(){
		String temp = ServletActionContext.getRequest().getParameter("teacherid");
		if(temp!=null){
			int teacherid = Integer.parseInt(temp);
			CommentPage commentPage = commentService.findCommentByTeacherID(teacherid,currentPage,pageSize,sortmethod);
			if(commentPage!=null){
				ServletActionContext.getRequest().setAttribute("commentPage", commentPage);
				ServletActionContext.getRequest().setAttribute("teacherid",teacherid);
				return SUCCESS;
				}
			return "fail";
		}
		return "fail";
	}
	public String findByCourse(){
		String temp = ServletActionContext.getRequest().getParameter("courseid");
		if(temp!=null){
			int courseid = Integer.parseInt(temp);
			CommentPage commentPage = commentService.findCommentByCourseID(courseid,currentPage,pageSize,sortmethod);
			if(commentPage!=null){
				ServletActionContext.getRequest().setAttribute("commentPage", commentPage);
				ServletActionContext.getRequest().setAttribute("courseid",courseid);
				return SUCCESS;
				}
			return "fail";
		}
		return "fail";
	}
	public String findByUser(){
		String temp = ServletActionContext.getRequest().getParameter("userid");
		if(temp!=null){
			int userid = Integer.parseInt(temp);
			CommentPage commentPage = commentService.findCommentByTeacherID(userid,currentPage,pageSize,sortmethod);
			if(commentPage!=null){
				ServletActionContext.getRequest().setAttribute("commentPage", commentPage);
				ServletActionContext.getRequest().setAttribute("userid",userid);
				return SUCCESS;
				}
			return "fail";
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
