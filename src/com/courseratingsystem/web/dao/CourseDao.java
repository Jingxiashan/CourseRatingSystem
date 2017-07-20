package com.courseratingsystem.web.dao;

import java.util.List;

import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.CourseOverview;

public interface CourseDao {
	public void add(Course course);
	public void update(Course course);
	public void delete(Course course);
	public CourseOverview findCourseOverviewByID(int courseid);
	public Course findCourseById(final int courseid);
	public List<CourseOverview> findCourseByName(String coursename);
	public List<CourseOverview> findAll();
	public List<CourseOverview> findCourseByTeacher(String teachername);
}
