package com.courseratingsystem.web.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.courseratingsystem.web.domain.Comment;
import com.courseratingsystem.web.object.CourseOverview;
import com.courseratingsystem.web.object.CourseOverviewPlusTeacher;
import com.courseratingsystem.web.service.CommentService;
import com.courseratingsystem.web.service.CourseService;
import com.courseratingsystem.web.service.TeacherService;
import com.courseratingsystem.web.service.impl.CommentServiceImpl;
import com.courseratingsystem.web.vo.CommentPage;
import com.courseratingsystem.web.vo.CoursePage;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherApi extends ActionSupport{
	public static final String STR_RESULT_CODE = "result_code";
	public static final String STR_REASON = "reason";
	public static final String STR_RESULT = "result";
	public static final int RESULT_CODE_OK = 200;
	public static final int RESULT_CODE_BAD_REQUEST = 400;
	
	private static final int pageSize = 10;
	String sortBy = CommentServiceImpl.COMMENT_SORT_METHOD_BYLIKECOUNT;
	
	private static final String FAIL = "fail";
	Map<String,Object> resultMap;
	Map<String,Object> returnMap;
	private Object returnJson;
	
	private CommentService commentService;
	private CourseService courseService;
	private TeacherService teacherService;
	public Object getReturnJson() {
		return returnJson;
	}
	public void setReturnJson(Object returnJson) {
		this.returnJson = returnJson;
	}
	public CommentService getCommentservice() {
		return commentService;
	}
	public void setCommentservice(CommentService commentservice) {
		this.commentService = commentservice;
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
	
	public String getCommentListAndCourseListByTeacherId(){
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentPage,teacherId;
		
		if(request.getParameter("teacherId")!=null){
			teacherId = Integer.parseInt(request.getParameter("courseId"));
		}else {
			teacherId = 0;
		}
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	
		}else {
			currentPage = 1;
		}
		
		CommentPage commentPage = null;
		commentPage = commentService.findCommentByTeacherID(teacherId, currentPage, pageSize, sortBy);
		String teacherName = teacherService.findTeacherByTeacherId(teacherId).getTeachername();
		List<CourseOverview> courseOverview = courseService.findCourseOverviewByTeacherid(teacherId);
		
		//构建JSon-commentList
		List<Map<String, Object>> commentList = new ArrayList<>();
		Map<String, Object> commentAttr;
		for(Comment tmpComment : commentPage.getCommentList()){
			commentAttr = new HashMap<>();
			commentAttr.put("commentId", tmpComment.getCommentid());
			commentAttr.put("timeStamp", tmpComment.getTimestamp());
			commentAttr.put("courseId", tmpComment.getCourse().getCourseid());
			commentAttr.put("courseName", tmpComment.getCourse().getCoursename());
			commentAttr.put("userId", tmpComment.getUser().getUserid());
			commentAttr.put("nickName", tmpComment.getUser().getNickname());
			commentAttr.put("ratingUsefulness", tmpComment.getRatingUsefulness());
			commentAttr.put("ratingVividness", tmpComment.getRatingVividness());
			commentAttr.put("ratingSpareTimeOccupation", tmpComment.getRatingSpareTimeOccupation());
			commentAttr.put("ratingScoring", tmpComment.getRatingScoring());
			commentAttr.put("ratingRollCall", tmpComment.getRatingRollCall());
			commentAttr.put("recommandScore", tmpComment.getRecommandScore());
			commentAttr.put("critics", tmpComment.getCritics());
			commentAttr.put("likeCount", tmpComment.getLikeCount());
			
			commentList.add(commentAttr);
		};
		
		//构建JSon-courseList
		List<Map<String, Object>> courseList = new ArrayList<>();
		Map<String, Object> courseAttr;
		for(CourseOverview tmpCourse : courseOverview){
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
			
			courseList.add(courseAttr);
		}
		
		resultMap.put("teacherId", teacherId);
		resultMap.put("teacherName", teacherName);
		resultMap.put("sortBy", sortBy);
		resultMap.put("currentPage", commentPage.getCurrentPage());
		resultMap.put("pageSize", commentPage.getPageSize());
		resultMap.put("totalPage", commentPage.getTotalPage());
		resultMap.put("commentList", commentList);
		resultMap.put("courseList", courseList);
		
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		returnMap.put(STR_RESULT, resultMap);
		
		returnJson = JSON.toJSON(returnMap);
		
		return SUCCESS;
	}
}
