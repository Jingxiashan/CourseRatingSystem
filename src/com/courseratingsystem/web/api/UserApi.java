package com.courseratingsystem.web.api;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.alibaba.fastjson.JSON;
import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.CourseService;
import com.courseratingsystem.web.service.LogininfoService;
import com.courseratingsystem.web.service.UserService;
import com.courseratingsystem.web.service.impl.LogininfoServiceImpl;
import com.courseratingsystem.web.vo.CoursePage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserApi extends ActionSupport{
	public static final String STR_RESULT_CODE = "result_code";
	public static final String STR_REASON = "reason";
	public static final String STR_RESULT = "result";
	public static final int RESULT_CODE_OK = 200;
	public static final int RESULT_CODE_BAD_REQUEST = 400;
			
	private static final String MSG_LOGIN_FAILED = "用户名或密码错误，请重试";
	private static final String MSG_LOGIN_ERROR = "出现未知错误，请重试";
	private static final String MSG_REGISTER_FAILED_DUPLICATE = "用户名已存在，换一个试试吧";
	private static final String MSG_GETUSER_FAILED_NOT_EXISTS = "不存在当前用户";
	private static final String FAIL = "fail";
	
	Map<String,Object> resultMap;
	Map<String,Object> returnMap;
	private Object returnJson;
	
	private LogininfoService logininfoService;
	private UserService userService;
	private CourseService courseService;

	public Object getReturnJson() {
		return returnJson;
	}
	public void setReturnJson(Object returnJson) {
		this.returnJson = returnJson;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public LogininfoService getLogininfoService() {
		return logininfoService;
	}
	public void setLogininfoService(LogininfoService logininfoService) {
		this.logininfoService = logininfoService;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	public String login() {
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Logininfo logininfo = new Logininfo();
		logininfo.setUsername(username);
		logininfo.setPassword(password);
		User tmpUser = logininfoService.login(logininfo);
		if(tmpUser != null) {
			//登陆成功
			resultMap.put("userid", tmpUser.getUserid());
			returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
			returnMap.put(STR_REASON, SUCCESS);
			returnMap.put(STR_RESULT, resultMap);
			returnJson = JSON.toJSON(returnMap);
		}else{
			//用户名或密码错误，登陆失败
			returnMap.put(STR_RESULT_CODE, RESULT_CODE_BAD_REQUEST);
			returnMap.put(STR_REASON, MSG_LOGIN_FAILED);
			returnJson = JSON.toJSON(returnMap);
		}
		return SUCCESS;
	}
	
	public String register() {
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String grade = request.getParameter("grade");
		if(logininfoService.findLogininfoByusername(username) != null) {
			//已经存在相同的用户名
			returnMap.put(STR_RESULT_CODE, RESULT_CODE_BAD_REQUEST);
			returnMap.put(STR_REASON, MSG_REGISTER_FAILED_DUPLICATE);
			returnJson = JSON.toJSON(returnMap);
		}else {
			//用户名可以注册
			//先在UserService里面注册，获得user
			User tmpUser = userService.register(new User(nickname,grade));
			//然后在LoginService里面注册
			logininfoService.register(tmpUser, username, password);
			resultMap.put("userid", tmpUser.getUserid());
			returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
			returnMap.put(STR_REASON, SUCCESS);
			returnMap.put(STR_RESULT, resultMap);
			returnJson = JSON.toJSON(returnMap);
		}
		return SUCCESS;
	}
	
	public String getUser() {
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String str_userid = request.getParameter("userid");
		if(str_userid != null) {
			int userid = Integer.parseInt(str_userid);
			User tmpUser = userService.findUserById(userid);
			if(tmpUser != null) {
				//存在当前用户
				resultMap.put("nickname", tmpUser.getNickname());
				resultMap.put("grade", tmpUser.getGrade());
				resultMap.put("wechat", tmpUser.getWechatAccount());
				resultMap.put("intro", tmpUser.getIntroduction());
				resultMap.put("picpath", tmpUser.getPicpath());
				returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
				returnMap.put(STR_REASON, SUCCESS);
				returnMap.put(STR_RESULT, resultMap);
				returnJson = JSON.toJSON(returnMap);
			}else {
				//不存在当前用户
				returnMap.put(STR_RESULT_CODE, RESULT_CODE_BAD_REQUEST);
				returnMap.put(STR_REASON, MSG_GETUSER_FAILED_NOT_EXISTS);
				returnJson = JSON.toJSON(returnMap);
			}
		}
		return SUCCESS;
	}
	
	//public void deleteFavourateCourse(int userid, Course course);
	public String deleteFavorateCourse(){
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int userId,courseId;
		
		if(request.getParameter("userId")!=null){
			userId = Integer.parseInt(request.getParameter("userId"));
		}else {
			return FAIL;
		}
		if(request.getParameter("courseId")!=null){
			courseId = Integer.parseInt(request.getParameter("courseId"));
		}else {
			return FAIL;
		}
		
		Course course = courseService.findCourseById(courseId);
		userService.deleteFavourateCourse(userId, course);
		
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		
		returnJson = JSON.toJSON(returnMap);
		
		return SUCCESS;
	}
	
	public String modifyProfile(){
		HttpServletRequest request = ServletActionContext.getRequest();
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String nickname = request.getParameter("nickname");
//		String grade = request.getParameter("grade");
//		Object tmp = userInfo.getAvatar();
//		if(userInfo.getAvatar() != null) {
//			File avatarFile = userInfo.getAvatar().get(0);
//			String avatarFileName = userInfo.getAvatarFileName();
//			String fileFinalName =  "/" + currentUser.getUserid() +avatarFileName.substring(avatarFileName.lastIndexOf("."));
//			String uploadRuselt = uploadFile(avatarFile,fileFinalName);
//			if(FAIL.equals(uploadRuselt)) {
//				result = "文件上传失败，请重试";
//				return FAIL;
//			}else {
//				currentUser.setPicpath(PREFIXDIR + UPLOADDIR + fileFinalName);
//			}
//		}
//		//setInfo
//		currentUser.setGrade(userInfo.getGrade());
//		currentUser.setNickname(userInfo.getNickname());
//		currentUser.setWechatAccount(userInfo.getWechatAccount());
//		currentUser.setIntroduction(userInfo.getIntroduction());
//		userService.update(currentUser);
//		//最后 更新session里面的user
//		ServletActionContext.getRequest().getSession().setAttribute("user", currentUser);
//		result = SUCCESS;
		return SUCCESS;
	}
	
	//public boolean changepassword(int userid,String oldpassword,String newpassword);
	public String changepassword(){
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int userId;
		String oldPassword,newPassword;
		
		if(request.getParameter("userId")!=null){
			userId = Integer.parseInt(request.getParameter("userId"));
		}else {
			return FAIL;
		}
		if(request.getParameter("oldPassword")!=null){
			oldPassword = request.getParameter("oldPassword");
		}else {
			return FAIL;
		}
		if(request.getParameter("newPassword")!=null){
			newPassword = request.getParameter("newPassword");
		}else {
			return FAIL;
		}
		
		logininfoService.changepassword(userId, oldPassword, newPassword);
		
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		
		returnJson = JSON.toJSON(returnMap);
		
		return SUCCESS;
	}
	
	//public List<Course> findFavouratesById(int userid);
	public String getFavoriteCourseList(){
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int userId;
		
		if(request.getParameter("userId")!=null){
			userId = Integer.parseInt(request.getParameter("userId"));
		}else {
			return FAIL;
		}
		
		List<Course> courseList = userService.findFavouratesById(userId);
		
		//构建JSon
		List<Map<String, Object>> favoriteCourseList = new ArrayList<>();
		Map<String, Object> favoriteCourseAttr;
		for(Course tmpCourse : courseList){
			favoriteCourseAttr = new HashMap<>();
			favoriteCourseAttr.put("courseId", tmpCourse.getCourseid());
			favoriteCourseAttr.put("courseName", tmpCourse.getCoursename());
			favoriteCourseAttr.put("averageRatingUsefulness", tmpCourse.getCoursemark().getAverageRatingsUsefulness());
			favoriteCourseAttr.put("averageRatingsRollCall", tmpCourse.getCoursemark().getAverageRatingsRollCall());
			favoriteCourseAttr.put("averageRatingsScoring", tmpCourse.getCoursemark().getAverageRatingsScoring());
			favoriteCourseAttr.put("averageRatingsSpareTimeOccupation", tmpCourse.getCoursemark().getAverageRatingsSpareTimeOccupation());
			favoriteCourseAttr.put("averageRatingsVividness", tmpCourse.getCoursemark().getAverageRatingsVividness());
			favoriteCourseAttr.put("recommendationScore", tmpCourse.getCoursemark().getRecommendationScore());
			favoriteCourseAttr.put("finalType", tmpCourse.getCoursemark().getFinalType());
			favoriteCourseAttr.put("peopleCount", tmpCourse.getCoursemark().getPeopleCount());
			
			favoriteCourseList.add(favoriteCourseAttr);
		}
		
		resultMap.put("favoriteCourseList", favoriteCourseList);
		
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		returnMap.put(STR_RESULT, resultMap);
		
		returnJson = JSON.toJSON(returnMap);
		
		return SUCCESS;
	}
	
	//public void addFavourateCourse(int userid, Course course);
	public String addFavourateCourse(){
		returnMap = new HashMap<String,Object>();
		resultMap = new HashMap<>();
		HttpServletRequest request = ServletActionContext.getRequest();
		int userId,courseId;
		
		if(request.getParameter("userId")!=null){
			userId = Integer.parseInt(request.getParameter("userId"));
		}else {
			return FAIL;
		}
		if(request.getParameter("courseId")!=null){
			courseId = Integer.parseInt(request.getParameter("courseId"));
		}else {
			return FAIL;
		}
		
		Course course = courseService.findCourseById(courseId);
		userService.addFavourateCourse(userId, course);
		
		returnMap.put(STR_RESULT_CODE, RESULT_CODE_OK);
		returnMap.put(STR_REASON, SUCCESS);
		
		returnJson = JSON.toJSON(returnMap);
		
		return SUCCESS;
	}
	
}
