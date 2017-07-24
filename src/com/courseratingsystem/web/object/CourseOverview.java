package com.courseratingsystem.web.object;

public class CourseOverview {
	private Integer courseid;
	private String coursename;
	private Float averageRatingsUsefulness;
	private Float averageRatingsVividness;
	private Float averageRatingsSpareTimeOccupation;
	private Float averageRatingsScoring;
	private Float averageRatingsRollCall;
	private Integer peopleCount;
	private Float recommendationScore;
	private Integer finalType;
	public CourseOverview(){};
	public CourseOverview(CourseOverview tmpCourse) {
		super();
		this.courseid = tmpCourse.courseid;
		this.coursename = tmpCourse.coursename;
		this.averageRatingsUsefulness = tmpCourse.averageRatingsUsefulness;
		this.averageRatingsVividness = tmpCourse.averageRatingsVividness;
		this.averageRatingsSpareTimeOccupation = tmpCourse.averageRatingsSpareTimeOccupation;
		this.averageRatingsScoring = tmpCourse.averageRatingsScoring;
		this.averageRatingsRollCall = tmpCourse.averageRatingsRollCall;
		this.peopleCount = tmpCourse.peopleCount;
		this.recommendationScore = tmpCourse.recommendationScore;
		this.finalType = tmpCourse.finalType;
		}
	public CourseOverview(Integer courseid, String coursename,
			Float averageRatingsUsefulness,
			Float averageRatingsVividness,
			Float averageRatingsSpareTimeOccupation,
			Float averageRatingsScoring, Float averageRatingsRollCall,
			Integer peopleCount, Float recommendationScore, Integer finalType) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.averageRatingsUsefulness = averageRatingsUsefulness;
		this.averageRatingsVividness = averageRatingsVividness;
		this.averageRatingsSpareTimeOccupation = averageRatingsSpareTimeOccupation;
		this.averageRatingsScoring = averageRatingsScoring;
		this.averageRatingsRollCall = averageRatingsRollCall;
		this.peopleCount = peopleCount;
		this.recommendationScore = recommendationScore;
		this.finalType = finalType;
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
	public Float getAverageRatingsUsefulness() {
		return averageRatingsUsefulness;
	}
	public void setAverageRatingsUsefulness(Float averageRatingsUsefulness) {
		this.averageRatingsUsefulness = averageRatingsUsefulness;
	}
	public Float getAverageRatingsVividness() {
		return averageRatingsVividness;
	}
	public void setAverageRatingsVividness(Float averageRatingsVividness) {
		this.averageRatingsVividness = averageRatingsVividness;
	}
	public Float getAverageRatingsSpareTimeOccupation() {
		return averageRatingsSpareTimeOccupation;
	}
	public void setAverageRatingsSpareTimeOccupation(
			Float averageRatingsSpareTimeOccupation) {
		this.averageRatingsSpareTimeOccupation = averageRatingsSpareTimeOccupation;
	}
	public Float getAverageRatingsScoring() {
		return averageRatingsScoring;
	}
	public void setAverageRatingsScoring(Float averageRatingsScoring) {
		this.averageRatingsScoring = averageRatingsScoring;
	}
	public Float getAverageRatingsRollCall() {
		return averageRatingsRollCall;
	}
	public void setAverageRatingsRollCall(Float averageRatingsRollCall) {
		this.averageRatingsRollCall = averageRatingsRollCall;
	}
	public Integer getPeopleCount() {
		return peopleCount;
	}
	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}
	public Float getRecommendationScore() {
		return recommendationScore;
	}
	public void setRecommendationScore(Float recommendationScore) {
		this.recommendationScore = recommendationScore;
	}
	public Integer getFinalType() {
		return finalType;
	}
	public void setFinalType(Integer finalType) {
		this.finalType = finalType;
	}
}
