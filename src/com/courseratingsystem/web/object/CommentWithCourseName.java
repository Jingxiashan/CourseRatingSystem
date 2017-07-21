package com.courseratingsystem.web.object;

import java.util.Date;
import java.util.List;

public class CommentWithCourseName {
	private Integer courseid;
	private String coursename;
	private Integer commentid;
	private Date timestamp;
	public CommentWithCourseName() {
		super();
	}
	public CommentWithCourseName(Integer courseid, String coursename,
			Integer commentid, Date timestamp) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.commentid = commentid;
		this.timestamp = timestamp;
	}
	public Integer getCourseid() {
		return courseid;
	}
	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public Integer getCommentid() {
		return commentid;
	}
	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	

}
