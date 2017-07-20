package com.courseratingsystem.web.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.courseratingsystem.web.dao.CourseDao;
import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.CourseOverview;
import com.courseratingsystem.web.service.CourseService;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao;
	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao coursedao) {
		this.courseDao = coursedao;
	}

	@Override
	public void add(Course course) {
		courseDao.add(course);
		
	}

	@Override
	public void update(Course course) {
		courseDao.update(course);
		
	}

	@Override
	public void delete(Course course) {
		courseDao.delete(course);
		
	}

	@Override
	public CourseOverview findCourseOverviewById(int courseid) {
		return courseDao.findCourseOverviewByID(courseid);
	}

	@Override
	public List<CourseOverview> findCourseByName(String coursename) {
		
		return courseDao.findCourseByName(coursename);
	}

	@Override
	public List<CourseOverview> findAll() {
		
		return courseDao.findAll();
	}

	@Override
	public List<CourseOverview> findCourseByTeacher(String teachername) {
		
		return courseDao.findCourseByTeacher(teachername);
	}

	@Override
	public List<CourseOverview> Sort(List<CourseOverview> list, String sortby) {
		switch(sortby){
		case "averageRatingsUsefulness":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                int i = o2.getAverageRatingsUsefulness() - o1.getAverageRatingsUsefulness();   
	                return i;  
	            }  
	        });
			break;
		case "averageRatingsVividness":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                int i = o2.getAverageRatingsVividness() - o1.getAverageRatingsVividness();   
	                return i;  
	            }  
	        });
			break;
		case "averageRatingsSpareTimeOccupation":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                int i = o2.getAverageRatingsSpareTimeOccupation() - o1.getAverageRatingsSpareTimeOccupation();   
	                return i;  
	            }  
	        });
			break;
		case "averageRatingsScoring":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                int i = o2.getAverageRatingsScoring() - o1.getAverageRatingsScoring();   
	                return i;  
	            }  
	        });
			break;
		case "averageRatingsRollCall":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                int i = o2.getAverageRatingsRollCall() - o1.getAverageRatingsRollCall();   
	                return i;  
	            }  
	        });
			break;
		case "recommendationScore":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                int i = o2.getRecommendationScore() - o1.getRecommendationScore();   
	                return i;  
	            }  
	        });
			break;
		}
		return list;
	}


	@Override
	public Course findCourseById(int courseid) {
		return courseDao.findCourseById(courseid);
	}

}
