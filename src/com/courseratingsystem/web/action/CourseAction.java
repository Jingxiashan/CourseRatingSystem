package com.courseratingsystem.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.CourseOverview;
import com.courseratingsystem.web.service.CourseService;
import com.courseratingsystem.web.service.impl.CourseServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//class SearchInfo{
//	String searchtext;
//	String searchtype;
//	public String getSearchtext() {
//		return searchtext;
//	}
//	public void setSearchtext(String searchtext) {
//		this.searchtext = searchtext;
//	}
//	public String getSearchtype() {
//		return searchtype;
//	}
//	public void setSearchtype(String searchtype) {
//		this.searchtype = searchtype;
//	}
//}
public class CourseAction extends ActionSupport{
//	private SearchInfo searchinfo= new SearchInfo();
	private String searchtext = new String();
	public String getSearchtext() {
		return searchtext;
	}
	public void setSearchtext(String searchtext) {
		this.searchtext = searchtext;
	}
	private CourseService courseService;
	
//	public String findByID(){
//		try{
//			CourseOverview course1 = courseservice.findCourseByID(Integer.parseInt(searchinfo.getSearchtext()));
//			List<CourseOverview> list = null;
//			list.add(course1);
//			ServletActionContext.getRequest().setAttribute("courselist",list);
//			return "SUCCESS";
//		}
//		catch(Exception ex ){
//			return "fail";
//		}
//	}
	
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public String findByName(){
		List<CourseOverview> list = courseService.findCourseByName(searchtext);
		if(!list.isEmpty()){
			ServletActionContext.getRequest().setAttribute("courselist", list);
			return "SUCCESS";
		}
		else{
			return "fail";
		}
	}
	public String findByTeacher(){
		List<CourseOverview> list = courseService.findCourseByTeacher(searchtext);
		if(!list.isEmpty()){
			ServletActionContext.getRequest().setAttribute("courselist", list);
			return "SUCCESS";
		}
		else{
			return "fail";
		}
	}
	public String findAll(){
		List<CourseOverview> list = courseService.findAll();
		if(!list.isEmpty()){
			ServletActionContext.getRequest().setAttribute("courselist", list);
			return "SUCCESS";
		}
		else{
			return "fail";
		}
	}
	public CourseService getCourseservice() {
		return courseService;
	}
	public void setCourseservice(CourseService courseservice) {
		this.courseService = courseservice;
	}
	
}
