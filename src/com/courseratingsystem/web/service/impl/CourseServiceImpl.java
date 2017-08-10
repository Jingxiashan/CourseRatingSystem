package com.courseratingsystem.web.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.courseratingsystem.web.dao.CourseDao;
import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.object.CourseOverview;
import com.courseratingsystem.web.service.CourseService;
import com.courseratingsystem.web.vo.CoursePage;

public class CourseServiceImpl implements CourseService {
	public static final String COURSE_SORT_METHOD_BY_USEF = "averageRatingsUsefulness";
	public static final String COURSE_SORT_METHOD_BY_VIVI = "averageRatingsVividness";
	public static final String COURSE_SORT_METHOD_BY_SPAR = "averageRatingsSpareTimeOccupation";
	public static final String COURSE_SORT_METHOD_BY_SCOR = "averageRatingsScoring";
	public static final String COURSE_SORT_METHOD_BY_ROLL = "averageRatingsRollCall";
	public static final String COURSE_SORT_METHOD_BY_RECO = "recommendationScore";
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
	public CoursePage findCourseByName(String coursename,String sortby,int currentPage,int pageSize) {
		
		List<CourseOverview> list = courseDao.findCourseByName(coursename);
		Sort(list, sortby);
		return toPage(list, currentPage, pageSize);
	}

	@Override
	public CoursePage findAll(String sortby,int currentPage,int pageSize) {
		
		List<CourseOverview> list = courseDao.findAll();
		Sort(list, sortby);
		return toPage(list, currentPage, pageSize);
	}

	@Override
	public CoursePage findCourseByTeachername(String teachername,String sortby,int currentPage,int pageSize) {
		
		List<CourseOverview> list = courseDao.findCourseByTeachername(teachername);
		Sort(list, sortby);
		return toPage(list, currentPage, pageSize);
	}
	@Override
	public CoursePage findHotTwentyCourses() {
		List<CourseOverview> list = courseDao.findAll();
		Sort(list, "peopleCount");
		return toPage(list, 1, 20);
	}
	@Override
	public List<CourseOverview> Sort(List<CourseOverview> list, String sortby) {
		switch(sortby){
		case "averageRatingsUsefulness":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                float i = o2.getAverageRatingsUsefulness() - o1.getAverageRatingsUsefulness();   
	                return i > 0 ? 1 : (i < 0 ? -1 : 0);  
	            }  
	        });
			break;
		case "averageRatingsVividness":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                float i = o2.getAverageRatingsVividness() - o1.getAverageRatingsVividness();      
	                return i > 0 ? 1 : (i < 0 ? -1 : 0);  
	            }  
	        });
			break;
		case "averageRatingsSpareTimeOccupation":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                float i = o2.getAverageRatingsSpareTimeOccupation() - o1.getAverageRatingsSpareTimeOccupation();   
	                return i > 0 ? 1 : (i < 0 ? -1 : 0);  
	            }  
	        });
			break;
		case "averageRatingsScoring":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                float i = o2.getAverageRatingsScoring() - o1.getAverageRatingsScoring();     
	                return i > 0 ? 1 : (i < 0 ? -1 : 0);  
	            }  
	        });
			break;
		case "averageRatingsRollCall":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                float i = o2.getAverageRatingsRollCall() - o1.getAverageRatingsRollCall();    
	                return i > 0 ? 1 : (i < 0 ? -1 : 0);  
	            }  
	        });
			break;
		case "recommendationScore":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                float i = o2.getRecommendationScore() - o1.getRecommendationScore();      
	                return i > 0 ? 1 : (i < 0 ? -1 : 0);  
	            }  
	        });
			break;
		case "peopleCount":
			Collections.sort(list, new Comparator<CourseOverview>() {  
				  
	            @Override  
	            public int compare(CourseOverview o1, CourseOverview o2) {  
	                float i = o2.getPeopleCount() - o1.getPeopleCount();      
	                return i > 0 ? 1 : (i < 0 ? -1 : 0);  
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
	public CoursePage toPage(List<CourseOverview> list,int currentPage,int pageSize){
//		List<CourseOverview> list = (List<CourseOverview>) ServletActionContext.getRequest().getSession().getAttribute("courselist");
		List<CourseOverview> page = list.subList((currentPage - 1) * pageSize, currentPage * pageSize < list.size() ? currentPage * pageSize : list.size());
		int totalCount = list.size();
		int totalPage = totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1;
		CoursePage coursepage = new CoursePage(pageSize, currentPage, totalCount, totalPage, page);
//		ServletActionContext.getRequest().getSession().setAttribute("coursepage", coursepage);
		return coursepage;
		}

	@Override
	public List<CourseOverview> findCourseOverviewByTeacherid(int teacherid) {
		return courseDao.findCourseByTeacherid(teacherid);
	}

//	@Override
//	public List<CommentWithCourseName> findCommentWithCourseNameByTeacherid(int teacherid) {
//		return courseDao.findCommentWithCourseNameByTeacherid(teacherid);
//	}
	
}
