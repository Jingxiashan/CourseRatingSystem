package com.courseratingsystem.web.service;

import java.util.List;

import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.CourseOverview;

public interface CourseService {
	public void add(Course course);
	public void update(Course course);
	public void delete(Course course);
	public CourseOverview findCourseByID(int courseid);
	public List<CourseOverview> findCourseByName(String coursename);
	public List<CourseOverview> findAll();
	public List<CourseOverview> findCourseByTeacher(String teachername);
	public List<CourseOverview> Sort(List<CourseOverview> list,String sort);
	}
