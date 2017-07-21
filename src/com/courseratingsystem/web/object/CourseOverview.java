package com.courseratingsystem.web.object;

public class CourseOverview {
	private Integer courseid;
	private String coursename;
	private Integer averageRatingsUsefulness;
	private Integer averageRatingsVividness;
	private Integer averageRatingsSpareTimeOccupation;
	private Integer averageRatingsScoring;
	private Integer averageRatingsRollCall;
	private Integer peopleCount;
	private Integer recommendationScore;
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
			Integer averageRatingsUsefulness,
			Integer averageRatingsVividness,
			Integer averageRatingsSpareTimeOccupation,
			Integer averageRatingsScoring, Integer averageRatingsRollCall,
			Integer peopleCount, Integer recommendationScore, Integer finalType) {
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
	public Integer getAverageRatingsUsefulness() {
		return averageRatingsUsefulness;
	}
	public void setAverageRatingsUsefulness(Integer averageRatingsUsefulness) {
		this.averageRatingsUsefulness = averageRatingsUsefulness;
	}
	public Integer getAverageRatingsVividness() {
		return averageRatingsVividness;
	}
	public void setAverageRatingsVividness(Integer averageRatingsVividness) {
		this.averageRatingsVividness = averageRatingsVividness;
	}
	public Integer getAverageRatingsSpareTimeOccupation() {
		return averageRatingsSpareTimeOccupation;
	}
	public void setAverageRatingsSpareTimeOccupation(
			Integer averageRatingsSpareTimeOccupation) {
		this.averageRatingsSpareTimeOccupation = averageRatingsSpareTimeOccupation;
	}
	public Integer getAverageRatingsScoring() {
		return averageRatingsScoring;
	}
	public void setAverageRatingsScoring(Integer averageRatingsScoring) {
		this.averageRatingsScoring = averageRatingsScoring;
	}
	public Integer getAverageRatingsRollCall() {
		return averageRatingsRollCall;
	}
	public void setAverageRatingsRollCall(Integer averageRatingsRollCall) {
		this.averageRatingsRollCall = averageRatingsRollCall;
	}
	public Integer getPeopleCount() {
		return peopleCount;
	}
	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}
	public Integer getRecommendationScore() {
		return recommendationScore;
	}
	public void setRecommendationScore(Integer recommendationScore) {
		this.recommendationScore = recommendationScore;
	}
	public Integer getFinalType() {
		return finalType;
	}
	public void setFinalType(Integer finalType) {
		this.finalType = finalType;
	}
}
