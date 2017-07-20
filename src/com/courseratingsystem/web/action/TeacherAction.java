package com.courseratingsystem.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Teacher;
import com.courseratingsystem.web.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TeacherAction extends ActionSupport implements ModelDriven<Teacher>{
	Teacher teacher = new Teacher();
	TeacherService teacherService;
	private String teachername;
	private int teacherid;

	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public Teacher getModel() {
		return teacher;
	}
	
	public String findTeacherByID(){
		String temp = ServletActionContext.getRequest().getParameter("teacherid");
		if(temp!=null){
			int teacherid = Integer.parseInt(temp);
			List<Teacher> teacherList = teacherService.findTeacherByTeacherId(teacherid);
			if(!teacherList.isEmpty()){
				ServletActionContext.getRequest().setAttribute("teacherlist", teacherList);
				ServletActionContext.getRequest().setAttribute("teacherid", teacherid);
				return SUCCESS;
			}
			return "fail";
		}
		return "fail";
	}
}
