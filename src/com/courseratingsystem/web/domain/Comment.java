package com.courseratingsystem.web.domain;

// Generated 2017-7-18 14:18:31 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Comment generated by hbm2java
 */
public class Comment implements java.io.Serializable{

	private Integer commentid;
	private Date timestamp;
	
	private Teacher teacher;
	private Course course;
	private User user;
	private Integer ratingUsefulness;
	private Integer ratingVividness;
	private Integer ratingSpareTimeOccupation;
	private Integer ratingScoring;
	private Integer ratingRollCall;
	private Integer recommandScore;
	private String critics;
	private Integer likeCount;

	public Comment() {
	}

	public Comment(Teacher teacher, Course course, User user) {
		this.teacher = teacher;
		this.course = course;
		this.user = user;
	}

	public Comment(Teacher teacher, Course course, User user,
			Integer ratingUsefulness, Integer ratingVividness,
			Integer ratingSpareTimeOccupation, Integer ratingScoring,
			Integer ratingRollCall, Integer recommandScore, String critics,
			Integer likeCount) {
		this.teacher = teacher;
		this.course = course;
		this.user = user;
		this.ratingUsefulness = ratingUsefulness;
		this.ratingVividness = ratingVividness;
		this.ratingSpareTimeOccupation = ratingSpareTimeOccupation;
		this.ratingScoring = ratingScoring;
		this.ratingRollCall = ratingRollCall;
		this.recommandScore = recommandScore;
		this.critics = critics;
		this.likeCount = likeCount;
	}

	public Integer getCommentid() {
		return this.commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getRatingUsefulness() {
		return this.ratingUsefulness;
	}

	public void setRatingUsefulness(Integer ratingUsefulness) {
		this.ratingUsefulness = ratingUsefulness;
	}

	public Integer getRatingVividness() {
		return this.ratingVividness;
	}

	public void setRatingVividness(Integer ratingVividness) {
		this.ratingVividness = ratingVividness;
	}

	public Integer getRatingSpareTimeOccupation() {
		return this.ratingSpareTimeOccupation;
	}

	public void setRatingSpareTimeOccupation(Integer ratingSpareTimeOccupation) {
		this.ratingSpareTimeOccupation = ratingSpareTimeOccupation;
	}

	public Integer getRatingScoring() {
		return this.ratingScoring;
	}

	public void setRatingScoring(Integer ratingScoring) {
		this.ratingScoring = ratingScoring;
	}

	public Integer getRatingRollCall() {
		return this.ratingRollCall;
	}

	public void setRatingRollCall(Integer ratingRollCall) {
		this.ratingRollCall = ratingRollCall;
	}

	public Integer getRecommandScore() {
		return this.recommandScore;
	}

	public void setRecommandScore(Integer recommandScore) {
		this.recommandScore = recommandScore;
	}

	public String getCritics() {
		return this.critics;
	}

	public void setCritics(String critics) {
		this.critics = critics;
	}

	public Integer getLikeCount() {
		return this.likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
}
