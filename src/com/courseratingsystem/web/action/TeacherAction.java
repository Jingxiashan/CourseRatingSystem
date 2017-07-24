package com.courseratingsystem.web.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.courseratingsystem.web.object.CourseOverview;
import com.courseratingsystem.web.domain.Comment;
import com.courseratingsystem.web.domain.Teacher;
import com.courseratingsystem.web.service.CommentService;
import com.courseratingsystem.web.service.CourseService;
import com.courseratingsystem.web.service.TeacherService;
import com.courseratingsystem.web.service.impl.CommentServiceImpl;
import com.courseratingsystem.web.vo.CommentPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.net.httpserver.HttpServer;

public class TeacherAction extends ActionSupport implements ModelDriven<Teacher>{
	private int currentPage=1;
	private int pageSize=15;
	private String sortmethod=CommentServiceImpl.COMMENT_SORT_METHOD_BYLIKECOUNT;
	private Teacher teacher = new Teacher();
	private static final String FAIL = "fail";
	private TeacherService teacherService;
	private CourseService courseService;
	private CommentService commentService;
	
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
	public String getSortmethod() {
		return sortmethod;
	}
	public void setSortmethod(String sortmethod) {
		this.sortmethod = sortmethod;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
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
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	@Override
	public Teacher getModel() {
		return teacher;
	}
	
	public String getPage(){
		String temp = ServletActionContext.getRequest().getParameter("teacherid");
		if(temp!=null){
			int teacherid = Integer.parseInt(temp);
			Teacher teacher = teacherService.findTeacherByTeacherId(teacherid);
			if(teacher!=null){
				HttpServletRequest request = ServletActionContext.getRequest();
				//GET TEACHER NAME
				request.setAttribute("teacher", teacher);
				//GET COMMENTS
				CommentPage commentPage = commentService.findCommentByTeacherID(teacherid, currentPage, pageSize, sortmethod);
				if(!commentPage.getCommentList().isEmpty()){
					request.setAttribute("commentPage", commentPage);
				}
				//GET COURSES
				List<CourseOverview> courseList = courseService.findCourseOverviewByTeacherid(teacherid);
				request.setAttribute("courseList", courseList);
				return SUCCESS;
			}
			return FAIL;
		}
		return FAIL;
	}
	
	public String findTeachersByTeachername(){
		String teachername = ServletActionContext.getRequest().getParameter("teachername");
		if(teachername!=null){
			List<Teacher> teacherList = teacherService.findTeachersByTeachername(teachername);
			if(!teacherList.isEmpty()){
				ServletActionContext.getRequest().setAttribute("teacherList", teacherList);
				ServletActionContext.getRequest().setAttribute("teachername", teachername);
				return SUCCESS;
			}
			return FAIL;
		}
		return FAIL;
	}
	
	public String findTeachersByCourseID(){
		String temp = ServletActionContext.getRequest().getParameter("courseid");
		if(temp!=null){
			int courseid = Integer.parseInt(temp);
			List<Teacher> teacherList = teacherService.findTeachersByCourseID(courseid);
			if(!teacherList.isEmpty()){
				ServletActionContext.getRequest().setAttribute("teacherList", teacherList);
				ServletActionContext.getRequest().setAttribute("courseid", courseid);
				return SUCCESS;
			}
			return FAIL;
		}
		return FAIL;
	}
	
	public String findTeacherCourseByID(){
		String temp = ServletActionContext.getRequest().getParameter("teacherid");
		if(temp!=null){
			int teacherid = Integer.parseInt(temp);
			List<CourseOverview> courseList = courseService.findCourseOverviewByTeacherid(teacherid);
			if(!courseList.isEmpty()){
				ServletActionContext.getRequest().setAttribute("courseList", courseList);
				ServletActionContext.getRequest().setAttribute("teacherid", teacherid);
				return SUCCESS;
			}
			return FAIL;
		}
		return FAIL;
	}
	
}
