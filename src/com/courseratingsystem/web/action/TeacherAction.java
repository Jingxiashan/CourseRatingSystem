package com.courseratingsystem.web.action;

import java.util.List;
import org.apache.struts2.ServletActionContext;
import com.courseratingsystem.web.object.CommentWithCourseName;
import com.courseratingsystem.web.object.CourseOverview;
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
	
	public String findTeacherByTeacherId(){
		String temp = ServletActionContext.getRequest().getParameter("teacherid");
		if(temp!=null){
			int teacherid = Integer.parseInt(temp);
			Teacher teacher = teacherService.findTeacherByTeacherId(teacherid);
			if(teacher!=null){
				ServletActionContext.getRequest().setAttribute("teacher", teacher);
				ServletActionContext.getRequest().setAttribute("teacherid", teacherid);
				return SUCCESS;
			}
			return "fail";
		}
		return "fail";
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
			return "fail";
		}
		return "fail";
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
			return "fail";
		}
		return "fail";
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
			return "fail";
		}
		return "fail";
	}
	
	public String findCommentAndCourseByID(){
		String temp = ServletActionContext.getRequest().getParameter("teacherid");
		if(temp!=null){
			int teacherid = Integer.parseInt(temp);
			List<CommentWithCourseName> commentWithCourseNameList = courseService.findCommentWithCourseNameByTeacherid(teacherid);
			if(!commentWithCourseNameList.isEmpty()){
				ServletActionContext.getRequest().setAttribute("commentWithCourseNameList", commentWithCourseNameList);
				ServletActionContext.getRequest().setAttribute("teacherid", teacherid);
				return SUCCESS;
			}
			return "fail";
		}
		return "fail";
	}
}
