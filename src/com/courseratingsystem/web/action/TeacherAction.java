package com.courseratingsystem.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.CourseOverview;
import com.courseratingsystem.web.domain.Teacher;
import com.courseratingsystem.web.service.CommentService;
import com.courseratingsystem.web.service.CourseService;
import com.courseratingsystem.web.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeacherAction extends ActionSupport implements ModelDriven<Teacher>{
	private Teacher teacher = new Teacher();
	
	private TeacherService teacherService;
	private CourseService courseService;
	private CommentService commentService;

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
	
	public String findTeacherCourseByID(){
		String temp = ServletActionContext.getRequest().getParameter("teacherid");
		if(temp!=null){
			int tempteacherid = Integer.parseInt(temp);
			List<CourseOverview> courseList = courseService.findCourseOverviewByTeacherid(tempteacherid);
			if(!courseList.isEmpty()){
				ServletActionContext.getRequest().setAttribute("courseList", courseList);
				ServletActionContext.getRequest().setAttribute("teacherid", tempteacherid);
				return SUCCESS;
			}
			return "fail";
		}
		return "fail";
	}
	
	public String findCommentAndCourseByID(){
		return null;
	}
}

