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
	
	private CommentService commentService;
	
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
	
	//public CommentPage findCommentByCourseID(int courseid,int currentPage,int pageSize,String sortmethod);
	public String getCommentListByCourseId() {
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentPage,courseId;
		
		if(request.getParameter("courseId")!=null){
			courseId = Integer.parseInt(request.getParameter("courseId"));
		}else {
			return FAIL;
		}
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	
		}else {
			currentPage = 1;
		}
		
		CommentPage commentPage = null;
		commentPage = commentService.findCommentByCourseID(courseId, currentPage, pageSize, sortBy);
		
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
			teacherId = Integer.parseInt(request.getParameter("teacherId"));
		}else {
			return FAIL;
		}
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	
		}else {
			currentPage = 1;
		}
		CommentPage commentPage = null;
		commentPage = commentService.findCommentByTeacherID(teacherId, currentPage, pageSize, sortBy);
		
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
		
		if(request.getParameter("userId")!=null){
			userId = Integer.parseInt(request.getParameter("userId"));
		}else {
			return FAIL;
		}
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	
		}else {
			currentPage = 1;
		}
		CommentPage commentPage = null;
		commentPage = commentService.findCommentByUserID(userId, currentPage, pageSize, sortBy);
		
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
			commentAttr.put("picPath", tmpComment.getUser().getPicpath());
			
			commentList.add(commentAttr);
		};
		return commentList;
	}

	
	//public int addLikeCount(int commentid);
	public String addLikeCount(){
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int commentId;
		
		if(request.getParameter("commentId")!=null){
			commentId = Integer.parseInt(request.getParameter("commentId"));
		}else {
			return FAIL;
		}
		
		int likeCount = commentService.addLikeCount(commentId);
		
		resultMap.put("likeCount", likeCount);
		
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		returnMap.put(STR_RESULT, resultMap);
		
		returnJson = JSON.toJSON(returnMap);
		
		return SUCCESS;
	}

	//public void delete(Comment comment);
	public String deleteComment(){
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int commentId;
		
		if(request.getParameter("commentId")!=null){
			commentId = Integer.parseInt(request.getParameter("commentId"));
		}else {
			return FAIL;
		}
		
		Comment comment = commentService.findCommentByCommentID(commentId);
		commentService.delete(comment);
		
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		
		returnJson = JSON.toJSON(returnMap);
		
		return SUCCESS;
	}
	
	//public void add(Comment comment);
	public String adComment(){
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int teacherId,courseId,userId;
		float ratingUsefulness,ratingVividness,ratingSpareTimeOccupation,ratingScoring,ratingRollCall,recommandScore;
		String critics;
		
		teacherId = Integer.parseInt(request.getParameter("teacherId"));
		courseId = Integer.parseInt(request.getParameter("courseId"));
		userId = Integer.parseInt(request.getParameter("userId"));
		ratingUsefulness = Float.parseFloat(request.getParameter("ratingUsefulness"));
		ratingVividness = Float.parseFloat(request.getParameter("ratingVividness"));
		ratingSpareTimeOccupation = Float.parseFloat(request.getParameter("ratingSpareTimeOccupation"));
		ratingScoring = Float.parseFloat(request.getParameter("ratingScoring"));
		ratingRollCall = Float.parseFloat(request.getParameter("ratingRollCall"));
		recommandScore = Float.parseFloat(request.getParameter("recommandScore"));
		critics = request.getParameter("critics");
		
		Comment comment = new Comment(
				teacherId, courseId, userId, 
				ratingUsefulness, ratingVividness, ratingSpareTimeOccupation, 
				ratingScoring, ratingRollCall, recommandScore, 
				critics, 0);
		
		commentService.add(comment);
		
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		
		returnJson = JSON.toJSON(returnMap);
		
		return SUCCESS;
	}
	
}
