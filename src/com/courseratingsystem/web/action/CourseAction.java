package com.courseratingsystem.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.CourseOverview;
import com.courseratingsystem.web.service.CourseService;
import com.courseratingsystem.web.service.TeacherService;
import com.courseratingsystem.web.service.impl.CourseServiceImpl;
import com.courseratingsystem.web.vo.CoursePage;
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
	private int currentPage = 1;
	private int pageSize = 1;
	private String sortby="recommendationScore";
	public String getSortby() {
		return sortby;
	}
	public void setSortby(String sortby) {
		this.sortby = sortby;
	}
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
	private String searchtext = new String();
	public String getSearchtext() {
		return searchtext;
	}
	public void setSearchtext(String searchtext) {
		this.searchtext = searchtext;
	}
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
	public String findByName(){
		CoursePage coursepage = courseService.findCourseByName(searchtext,sortby,currentPage,pageSize);
		if(!coursepage.getList().isEmpty()){
			ServletActionContext.getRequest().setAttribute("coursepage", coursepage);
			return "SUCCESS";
		}
		else{
			return "fail";
		}
	}
	public String findByTeacher(){
		CoursePage coursepage = courseService.findCourseByTeachername(searchtext,sortby,currentPage,pageSize);
		if(!coursepage.getList().isEmpty()){
			ServletActionContext.getRequest().setAttribute("coursepage", coursepage);
			return "SUCCESS";
		}
		else{
			return "fail";
		}
	}
	public String findAll(){
		CoursePage coursepage = courseService.findAll(sortby,currentPage,pageSize);
		if(!coursepage.getList().isEmpty()){
			ServletActionContext.getRequest().setAttribute("coursepage", coursepage);
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
//	public String toPage(){
//		List<CourseOverview> list = (List<CourseOverview>) ServletActionContext.getRequest().getSession().getAttribute("courselist");
//		if(!list.isEmpty()){
//		List<CourseOverview> page = list.subList((currentPage - 1)*pageSize, currentPage*pageSize);
//		int totalCount = list.size();
//		int totalPage = totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1;
//		CoursePage coursepage = new CoursePage(pageSize, currentPage, totalCount, totalPage, page);
//		ServletActionContext.getRequest().getSession().setAttribute("coursepage", coursepage);
//		return "SUCCESS";
//		}
//		else{
//			return "fail";
//		}
//	}
}
