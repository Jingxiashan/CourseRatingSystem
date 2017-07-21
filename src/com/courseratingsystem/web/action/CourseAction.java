package com.courseratingsystem.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.object.CourseOverview;
import com.courseratingsystem.web.object.CourseOverviewPlusTeacher;
import com.courseratingsystem.web.service.CommentService;
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
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	private static final String GET_TO_COURSE_PAGE = "get_to_course_page";
	private int currentPage = 1;
	private int pageSize = 5;
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
	private CommentService commentService;

	
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
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
	public String findByName(){
		CoursePage coursepage = courseService.findCourseByName(searchtext,sortby,currentPage,pageSize);
		for(CourseOverviewPlusTeacher tmpCourse : coursepage.getList()) {
			tmpCourse.setTeacherList(teacherService.findTeachersByCourseID(tmpCourse.getCourseid()));
		}
		if(!coursepage.getList().isEmpty()){
			ServletActionContext.getRequest().setAttribute("coursepage", coursepage);
			return SUCCESS;
		}
		else{
			return FAIL;
		}
	}
	public String findByTeacher(){
		CoursePage coursepage = courseService.findCourseByTeachername(searchtext,sortby,currentPage,pageSize);
		for(CourseOverviewPlusTeacher tmpCourse : coursepage.getList()) {
			tmpCourse.setTeacherList(teacherService.findTeachersByCourseID(tmpCourse.getCourseid()));
		}
		if(!coursepage.getList().isEmpty()){
			ServletActionContext.getRequest().setAttribute("coursepage", coursepage);
			return SUCCESS;
		}
		else{
			return FAIL;
		}
	}
	public String findAll(){
		CoursePage coursepage = courseService.findAll(sortby,currentPage,pageSize);
		for(CourseOverviewPlusTeacher tmpCourse : coursepage.getList()) {
			tmpCourse.setTeacherList(teacherService.findTeachersByCourseID(tmpCourse.getCourseid()));
		}
		if(!coursepage.getList().isEmpty()){
			ServletActionContext.getRequest().setAttribute("coursepage", coursepage);
			return SUCCESS;
		}
		else{
			return FAIL;
		}
	}
	public String getPage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String str_courseid = request.getParameter("courseid");
		if(str_courseid != null){
			//get CourseOverviewPlusTeacher
			int courseid = Integer.parseInt(str_courseid);
			CourseOverviewPlusTeacher tmpCourse = new CourseOverviewPlusTeacher(courseService.findCourseOverviewById(courseid)); 
			tmpCourse.setTeacherList(teacherService.findTeachersByCourseID(tmpCourse.getCourseid()));
			request.setAttribute("course", tmpCourse);
			//get Comments
			//TODO
			return GET_TO_COURSE_PAGE;	
		}else {
			return FAIL;
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
//		return SUCCESS;
//		}
//		else{
//			return FAIL;
//		}
//	}
}
