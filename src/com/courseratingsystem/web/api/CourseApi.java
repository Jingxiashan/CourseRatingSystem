package com.courseratingsystem.web.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.courseratingsystem.web.domain.Comment;
import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.Teacher;
import com.courseratingsystem.web.object.CourseOverview;
import com.courseratingsystem.web.object.CourseOverviewPlusTeacher;
import com.courseratingsystem.web.service.CommentService;
import com.courseratingsystem.web.service.CourseService;
import com.courseratingsystem.web.service.LogininfoService;
import com.courseratingsystem.web.service.TeacherService;
import com.courseratingsystem.web.service.UserService;
import com.courseratingsystem.web.service.impl.CommentServiceImpl;
import com.courseratingsystem.web.service.impl.CourseServiceImpl;
import com.courseratingsystem.web.vo.CommentPage;
import com.courseratingsystem.web.vo.CoursePage;
import com.opensymphony.xwork2.ActionSupport;

public class CourseApi extends ActionSupport{
	public static final String STR_RESULT_CODE = "result_code";
	public static final String STR_REASON = "reason";
	public static final String STR_RESULT = "result";
	public static final int RESULT_CODE_OK = 200;
	public static final int RESULT_CODE_BAD_REQUEST = 400;
	
	public static final int COURSE_SEARCH_PARAM_COU = 0;
	public static final int COURSE_SEARCH_PARAM_TEA = 1;
	
	private static final int pageSize = 10;
	
	private static final String FAIL = "fail";
	Map<String,Object> resultMap;
	Map<String,Object> returnMap;
	private Object returnJson;
	private CourseService courseService;
	private TeacherService teacherService;
	private CommentService commentService;
	public CommentService getCommentService() {
		return commentService;
	}
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	public Object getReturnJson() {
		return returnJson;
	}
	public void setReturnJson(Object returnJson) {
		this.returnJson = returnJson;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	public String getCourseList() {
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int searchType, currentPage;
		String sortBy;
		String searchText;
		if(request.getParameter("searchType") != null) {
			searchType = Integer.parseInt(request.getParameter("searchType"));	
		}else {
			searchType = COURSE_SEARCH_PARAM_COU;
		}
		if(request.getParameter("searchText") != null) {
			searchText = request.getParameter("searchText");
		}else {
			searchText = new String("");
		}
		if(request.getParameter("sortBy") != null) {
			sortBy = request.getParameter("sortBy");	
		}else {
			sortBy = CourseServiceImpl.COURSE_SORT_METHOD_BY_RECO;
		}
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	
		}else {
			currentPage = 1;
		}
		CoursePage coursepage = null;
		if(searchText.isEmpty()) {
			//无搜索条件
			coursepage = courseService.findAll(sortBy,currentPage,pageSize);
		}else {
			//有搜索条件
			switch(searchType) {
				case COURSE_SEARCH_PARAM_COU:
					coursepage = courseService.findCourseByName(searchText,sortBy,currentPage,pageSize);
					break;
				case COURSE_SEARCH_PARAM_TEA:
					coursepage = courseService.findCourseByTeachername(searchText,sortBy,currentPage,pageSize);
					break;
			}
		}
		//设置老师
		for(CourseOverviewPlusTeacher tmpCourse : coursepage.getList()) {
			tmpCourse.setTeacherList(teacherService.findTeachersByCourseID(tmpCourse.getCourseid()));
		}
		List<Map<String,Object>>  courseList = toCourseList(coursepage);
		resultMap.put("searchtType", searchType);
		resultMap.put("searchText", searchText);
		resultMap.put("sortBy", sortBy);
		resultMap.put("currentPage", currentPage);
		resultMap.put("pageSize", coursepage.getPageSize());
		resultMap.put("totalPage", coursepage.getTotalPage());
		resultMap.put("courseList", courseList);
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		returnMap.put(STR_RESULT, resultMap);
		returnJson = JSON.toJSON(returnMap);
		return SUCCESS;
	}
	
	public String getHotCourseAndComment() {
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		
		CoursePage hotCoursePage = courseService.findHotTwentyCourses();
		CommentPage hotCommentPage = commentService.findTopTwentyComments();
		//设置老师
		for(CourseOverviewPlusTeacher tmpCourse : hotCoursePage.getList()) {
			tmpCourse.setTeacherList(teacherService.findTeachersByCourseID(tmpCourse.getCourseid()));
		}
		List<Map<String,Object>> courseList = toCourseList(hotCoursePage);
		List<Map<String,Object>> commentList = CommentApi.getCommentList(hotCommentPage);
		
		resultMap.put("courseList", courseList);
		resultMap.put("commentList", commentList);
		
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		returnMap.put(STR_RESULT, resultMap);
		returnJson = JSON.toJSON(returnMap);
		return SUCCESS;
	}
	
	public String getCourseWithTenComments(){
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int courseId;
		
		if(request.getParameter("courseId")!=null){
			courseId = Integer.parseInt(request.getParameter("courseId"));
		}else {
			return FAIL;
		}
		
		CommentPage commentPage = null;
		commentPage = commentService.findCommentByCourseID(courseId, 1, pageSize, CommentServiceImpl.COMMENT_SORT_METHOD_BYLIKECOUNT);
		Course course = courseService.findCourseById(courseId);
		
		List<Map<String, Object>> commentList = CommentApi.getCommentList(commentPage);
		
		List<Teacher> tmp_teacherList = teacherService.findTeachersByCourseID(courseId);
		
		List<Map<String, Object>> teacherList  = new ArrayList<>();
		Map<String,Object> teacherAttr;
		
		for(Teacher tmp_teacher : tmp_teacherList){
			teacherAttr = new HashMap<>();
			teacherAttr.put("teacherId", tmp_teacher.getTeacherid());
			teacherAttr.put("teacherName", tmp_teacher.getTeachername());
			
			teacherList.add(teacherAttr);
		}
		
		resultMap.put("commentList", commentList);
		resultMap.put("teacherList", teacherList);
		resultMap.put("courseId", courseId);
		resultMap.put("courseName",course.getCoursename());
		resultMap.put("averageRatingUsefulness", course.getCoursemark().getAverageRatingsUsefulness());
		resultMap.put("averageRatingsRollCall", course.getCoursemark().getAverageRatingsRollCall());
		resultMap.put("averageRatingsScoring", course.getCoursemark().getAverageRatingsScoring());
		resultMap.put("averageRatingsSpareTimeOccupation", course.getCoursemark().getAverageRatingsSpareTimeOccupation());
		resultMap.put("averageRatingsVividness", course.getCoursemark().getAverageRatingsVividness());
		resultMap.put("recommendationScore", course.getCoursemark().getRecommendationScore());
		resultMap.put("finalType", course.getCoursemark().getFinalType());
		resultMap.put("peopleCount", course.getCoursemark().getPeopleCount());
				
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		returnMap.put(STR_RESULT, resultMap);
		
		returnJson = JSON.toJSON(returnMap);
		
		return SUCCESS;
	}
	
	private static List<Map<String,Object>> toCourseList(CoursePage coursepage){
		//构建Json
		List<Map<String,Object>>  courseList = new ArrayList<>();
		Map<String,Object> courseAttr;
		List<Map<String,Object>> teacherList;
		Map<String,Object> teacherAttr;
		for(CourseOverviewPlusTeacher tmpCourse : coursepage.getList()) {
			courseAttr = new HashMap<>();
			courseAttr.put("courseId", tmpCourse.getCourseid());
			courseAttr.put("courseName", tmpCourse.getCoursename());
			courseAttr.put("peopleCount", tmpCourse.getPeopleCount());
			courseAttr.put("recScore", tmpCourse.getRecommendationScore());
			courseAttr.put("useScore", tmpCourse.getAverageRatingsUsefulness());
			courseAttr.put("vivScore", tmpCourse.getAverageRatingsVividness());
			courseAttr.put("ocuScore", tmpCourse.getAverageRatingsSpareTimeOccupation());
			courseAttr.put("scoScore", tmpCourse.getAverageRatingsScoring());
			courseAttr.put("rolScore", tmpCourse.getAverageRatingsRollCall());
			teacherList = new ArrayList<>();
			for(Teacher tmpTeacher : tmpCourse.getTeacherList()) {
				teacherAttr = new HashMap<>();
				teacherAttr.put("teacherId", tmpTeacher.getTeacherid());
				teacherAttr.put("teacherName", tmpTeacher.getTeachername());
				teacherList.add(teacherAttr);
			}
			courseAttr.put("teacherList", teacherList);
			courseList.add(courseAttr);
		}
		return courseList;
	}

}
