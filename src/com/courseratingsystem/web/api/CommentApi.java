package com.courseratingsystem.web.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.courseratingsystem.web.domain.Comment;
import com.courseratingsystem.web.service.CommentService;
import com.courseratingsystem.web.service.CourseService;
import com.courseratingsystem.web.service.TeacherService;
import com.courseratingsystem.web.service.impl.CommentServiceImpl;
import com.courseratingsystem.web.service.impl.CourseServiceImpl;
import com.courseratingsystem.web.vo.CommentPage;
import com.opensymphony.xwork2.ActionSupport;

public class CommentApi extends ActionSupport{
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
	
	private CommentService commentservice;
	private TeacherService teacherService;
	private CourseService courseService;
	
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
	public CommentService getCommentservice() {
		return commentservice;
	}
	public void setCommentservice(CommentService commentservice) {
		this.commentservice = commentservice;
	}
	
	//public CommentPage findCommentByCourseID(int courseid,int currentPage,int pageSize,String sortmethod);
	public String getCommentListByCourseId() {
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentPage,courseId;
		
		if(request.getParameter("courseId")!=null){
			courseId = Integer.parseInt(request.getParameter("courseId"));
		}else {
			courseId = 0;
		}
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	
		}else {
			currentPage = 1;
		}
		CommentPage commentPage = null;
		commentPage = commentservice.findCommentByCourseID(courseId, currentPage, pageSize, sortBy);
		
		List<Map<String, Object>> commentList = getCommentList(commentPage);
		
		resultMap.put("sortBy", sortBy);
		resultMap.put("currentPage", commentPage.getCurrentPage());
		resultMap.put("pageSize", commentPage.getPageSize());
		resultMap.put("totalPage", commentPage.getTotalPage());
		resultMap.put("commentList", commentList);
		
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		returnMap.put(STR_RESULT, resultMap);
		
		returnJson = JSON.toJSON(returnMap);
		
		return SUCCESS;
	}
	
	//public CommentPage findCommentByTeacherID(int teacherid,int currentPage,int pageSize,String sortmethod);
	public String getCommentListByTeacherId() {
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
		commentPage = commentservice.findCommentByTeacherID(teacherId, currentPage, pageSize, sortBy);
		
		List<Map<String, Object>> commentList = getCommentList(commentPage);
		resultMap.put("sortBy", sortBy);
		resultMap.put("currentPage", commentPage.getCurrentPage());
		resultMap.put("pageSize", commentPage.getPageSize());
		resultMap.put("totalPage", commentPage.getTotalPage());
		resultMap.put("commmetList", commentList);
		
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		returnMap.put(STR_RESULT, resultMap);
		
		returnJson = JSON.toJSON(returnMap);
		
		return SUCCESS;
	}

	//public CommentPage findCommentByUserID(int userid,int currentPage,int pageSize,String sortmethod);
	public String getCommentListByUserId() {
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentPage,userId;
		
		if(request.getParameter("teacherId")!=null){
			userId = Integer.parseInt(request.getParameter("courseId"));
		}else {
			userId = 0;
		}
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	
		}else {
			currentPage = 1;
		}
		CommentPage commentPage = null;
		commentPage = commentservice.findCommentByUserID(userId, currentPage, pageSize, sortBy);
		
		List<Map<String, Object>> commentList = getCommentList(commentPage);
		resultMap.put("sortBy", sortBy);
		resultMap.put("currentPage", commentPage.getCurrentPage());
		resultMap.put("pageSize", commentPage.getPageSize());
		resultMap.put("totalPage", commentPage.getTotalPage());
		resultMap.put("commentList", commentList);
		
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		returnMap.put(STR_RESULT, resultMap);
		
		returnJson = JSON.toJSON(returnMap);
		
		return SUCCESS;
	}
	
	public static List<Map<String, Object>> getCommentList(CommentPage commentPage) {
		//¹¹½¨JSon
		List<Map<String, Object>> commentList = new ArrayList<>();
		Map<String, Object> commentAttr;
		for(Comment tmpComment : commentPage.getCommentList()){
			commentAttr = new HashMap<>();
			commentAttr.put("commentId", tmpComment.getCommentid());
			commentAttr.put("timeStamp", tmpComment.getTimestamp());
			commentAttr.put("courseId", tmpComment.getCourse().getCourseid());
			commentAttr.put("courseName", tmpComment.getCourse().getCoursename());
			commentAttr.put("teacherId", tmpComment.getTeacher().getTeacherid());
			commentAttr.put("teacherName", tmpComment.getTeacher().getTeachername());
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
		return commentList;
	}

}
