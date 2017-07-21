package com.courseratingsystem.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Comment;
import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.object.CourseOverview;
import com.courseratingsystem.web.object.CourseOverviewPlusTeacher;
import com.courseratingsystem.web.service.CommentService;
import com.courseratingsystem.web.service.CourseService;
import com.courseratingsystem.web.service.TeacherService;
import com.courseratingsystem.web.service.impl.CommentServiceImpl;
import com.courseratingsystem.web.vo.CommentPage;
import com.courseratingsystem.web.vo.CoursePage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommentAction extends ActionSupport implements ModelDriven<Comment>{
	private int currentPage=1;
	private int pageSize=5;
	private static final String GET_TO_COMMENT_PAGE = "get_to_comment_page";;
	private static final String COMMENT_SUCCESS = "comment_success";
	private static final String FAIL = "fail";
	
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
	private CourseService courseService;
	private TeacherService teacherService;
	
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	private String sortmethod=CommentServiceImpl.COMMENT_SORT_METHOD_BYLIKECOUNT;

	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}	
	public CommentService getCommentService(){
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
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
	public String getPage(){
		String str_courseid = ServletActionContext.getRequest().getParameter("courseid");
		if(str_courseid != null) {
			int courseid = Integer.parseInt(str_courseid);
			CourseOverviewPlusTeacher tmpCourse = new CourseOverviewPlusTeacher(courseService.findCourseOverviewById(courseid)); 
			tmpCourse.setTeacherList(teacherService.findTeachersByCourseID(tmpCourse.getCourseid()));
			ServletActionContext.getRequest().setAttribute("course", tmpCourse);
			return GET_TO_COMMENT_PAGE;			
		}else return FAIL;
	}	
	
	public String addComment(){
		commentService.add(comment);
		return COMMENT_SUCCESS;
	}	

	@Override
	public Comment getModel() {
		return comment;
	}
}
