package com.courseratingsystem.web.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.CommentService;
import com.courseratingsystem.web.service.CourseService;
import com.courseratingsystem.web.service.UserService;
import com.courseratingsystem.web.service.impl.CommentServiceImpl;
import com.courseratingsystem.web.vo.CommentPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
public class UserAction extends ActionSupport implements ModelDriven<UserInfo>{

	UserService userService;
	CommentService commentService;
	CourseService courseService;
	private int currentPage = 1;
	private final int pageSize = 10;
	private int commentid;
	private String result;
	private static final String GET_TO_SELF_PROFILE = "get_to_self_profile";
	private static final String FAIL = "fail";
    private final static String UPLOADDIR = "/avatars";   
    private final static String PREFIXDIR = "/CourseRatingSystem";
	UserInfo userInfo = new UserInfo();

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	public String modifyProfile(){
		User currentUser =	(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		Object tmp = userInfo.getAvatar();
		if(userInfo.getAvatar() != null) {
			File avatarFile = userInfo.getAvatar().get(0);
			String avatarFileName = userInfo.getAvatarFileName();
			String fileFinalName =  "/" + currentUser.getUserid() +avatarFileName.substring(avatarFileName.lastIndexOf("."));
			String uploadRuselt = uploadFile(avatarFile,fileFinalName);
			if(FAIL.equals(uploadRuselt)) {
				result = "文件上传失败，请重试";
				return FAIL;
			}else {
				currentUser.setPicpath(PREFIXDIR + UPLOADDIR + fileFinalName);
			}
		}
		//setInfo
		currentUser.setGrade(userInfo.getGrade());
		currentUser.setNickname(userInfo.getNickname());
		currentUser.setWechatAccount(userInfo.getWechatAccount());
		currentUser.setIntroduction(userInfo.getIntroduction());
		userService.update(currentUser);
		//最后 更新session里面的user
		ServletActionContext.getRequest().getSession().setAttribute("user", currentUser);
		result = SUCCESS;
		return SUCCESS;
	}

	
	public String getOthersProfile(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String str_userid = request.getParameter("userid");
		if(str_userid != null) {
			int userid = Integer.parseInt(str_userid);
			if(request.getSession().getAttribute("user") != null){
				if(userid == ((User)request.getSession().getAttribute("user")).getUserid()){
					return GET_TO_SELF_PROFILE;
				}	
			}
			
			//save user in request
			User userToShow =	userService.findUserById(userid);
			ServletActionContext.getRequest().setAttribute("user", userToShow);

			//get comments
			CommentPage commentPage = commentService.findCommentByUserID(userToShow.getUserid(), currentPage, pageSize, CommentServiceImpl.COMMENT_SORT_METHOD_BYLIKECOUNT);
			ServletActionContext.getRequest().setAttribute("commentPage", commentPage);

			return SUCCESS;
		}else return FAIL;		
	}
	
	public String addFavourate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String str_courseid = request.getParameter("courseid");
		if(str_courseid != null) {
			int courseid = Integer.parseInt(str_courseid);
			User currentUser =	(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			userService.addFavourateCourse(currentUser.getUserid(), courseService.findCourseById(courseid));
			ServletActionContext.getRequest().getSession().setAttribute("user", userService.findUserById(currentUser.getUserid()));
			return SUCCESS;	
		}else return FAIL;
		
	}
	
	public String deleteFavourate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String str_courseid = request.getParameter("courseid");
		if(str_courseid != null) {
			int courseid = Integer.parseInt(str_courseid);
			User currentUser =	(User) ServletActionContext.getRequest().getSession().getAttribute("user");
			userService.deleteFavourateCourse(currentUser.getUserid(), courseService.findCourseById(courseid));
			ServletActionContext.getRequest().getSession().setAttribute("user", userService.findUserById(currentUser.getUserid()));
			return SUCCESS;	
		}else return FAIL;
		
	}
	

	 private String uploadFile(File file,String fileName){   
	        try {   
	            InputStream in = new FileInputStream(file);   
				String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);  
	            File fileLocation = new File(dir);  
	            //此处也可以在应用根目录手动建立目标上传目录  
	            if(!fileLocation.exists()){  
	                boolean isCreated  = fileLocation.mkdir();  
	                if(!isCreated) {  
	                    //目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。  
	                    return FAIL;  
	                }  
	            }  
	            File uploadFile = new File(dir, fileName);   
	            OutputStream out = new FileOutputStream(uploadFile);   
	            byte[] buffer = new byte[1024 * 1024];   
	            int length;   
	            while ((length = in.read(buffer)) > 0) {   
	                out.write(buffer, 0, length);   
	            }   
	            in.close();   
	            out.close();   
	        } catch (Exception e) {
	            e.printStackTrace();
	            return FAIL;
	        }
	        return SUCCESS;
	 } 
	
	
	@Override
	public UserInfo getModel() {
		return userInfo;
	}

}


class UserInfo{
	private String nickname;
	private String grade;
	private String introduction;
	private String wechatAccount;
    private List<File> avatar;   
    private String avatarFileName;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getWechatAccount() {
		return wechatAccount;
	}
	public void setWechatAccount(String wechatAccount) {
		this.wechatAccount = wechatAccount;
	}
	public List<File> getAvatar() {
		return avatar;
	}
	public void setAvatar(List<File> avatar) {
		this.avatar = avatar;
	}
	public String getAvatarFileName() {
		return avatarFileName;
	}
	public void setAvatarFileName(String avatarFileName) {
		this.avatarFileName = avatarFileName;
	}
}
