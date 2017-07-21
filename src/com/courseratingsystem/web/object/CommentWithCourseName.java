package com.courseratingsystem.web.object;

import java.util.Date;

public class CommentWithCourseName {
	private Integer courseid;
	private String coursename;
	private Integer commentid;
	private Integer userid;
	private Integer ratingUsefulness;
	private Integer ratingVividness;
	private Integer ratingSpareTimeOccupation;
	private Integer ratingScoring;
	private Integer ratingRollCall;
	private Integer recommandScore;
	private String critics;
	private Integer likeCount;
	private Date timestamp;
	
	public CommentWithCourseName() {
		super();
	}
	public CommentWithCourseName(Integer courseid, String coursename,
			Integer commentid, Integer userid, Integer ratingUsefulness,
			Integer ratingVividness, Integer ratingSpareTimeOccupation,
			Integer ratingScoring, Integer ratingRollCall,
			Integer recommandScore, String critics, Integer likeCount,
			Date timestamp) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.commentid = commentid;
		this.userid = userid;
		this.ratingUsefulness = ratingUsefulness;
		this.ratingVividness = ratingVividness;
		this.ratingSpareTimeOccupation = ratingSpareTimeOccupation;
		this.ratingScoring = ratingScoring;
		this.ratingRollCall = ratingRollCall;
		this.recommandScore = recommandScore;
		this.critics = critics;
		this.likeCount = likeCount;
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
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getRatingUsefulness() {
		return ratingUsefulness;
	}
	public void setRatingUsefulness(Integer ratingUsefulness) {
		this.ratingUsefulness = ratingUsefulness;
	}
	public Integer getRatingVividness() {
		return ratingVividness;
	}
	public void setRatingVividness(Integer ratingVividness) {
		this.ratingVividness = ratingVividness;
	}
	public Integer getRatingSpareTimeOccupation() {
		return ratingSpareTimeOccupation;
	}
	public void setRatingSpareTimeOccupation(Integer ratingSpareTimeOccupation) {
		this.ratingSpareTimeOccupation = ratingSpareTimeOccupation;
	}
	public Integer getRatingScoring() {
		return ratingScoring;
	}
	public void setRatingScoring(Integer ratingScoring) {
		this.ratingScoring = ratingScoring;
	}
	public Integer getRatingRollCall() {
		return ratingRollCall;
	}
	public void setRatingRollCall(Integer ratingRollCall) {
		this.ratingRollCall = ratingRollCall;
	}
	public Integer getRecommandScore() {
		return recommandScore;
	}
	public void setRecommandScore(Integer recommandScore) {
		this.recommandScore = recommandScore;
	}
	public String getCritics() {
		return critics;
	}
	public void setCritics(String critics) {
		this.critics = critics;
	}
	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
