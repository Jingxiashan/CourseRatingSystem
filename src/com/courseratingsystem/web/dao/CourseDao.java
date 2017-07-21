package com.courseratingsystem.web.dao;

import java.util.List;

import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.object.CommentWithCourseName;
import com.courseratingsystem.web.object.CourseOverview;

public interface CourseDao {
	public void add(Course course);
	public void update(Course course);
	public void delete(Course course);
	public Course findCourseById(final int courseid);
	public CourseOverview findCourseOverviewByID(int courseid);
	public List<CourseOverview> findCourseByName(String coursename);
	public List<CourseOverview> findAll();
	public List<CourseOverview> findCourseByTeachername(String teachername);
	public List<CourseOverview> findCourseByTeacherid(int teacherid);
	public List<CommentWithCourseName> findCommentWithCourseNameByTeacherid(int teacherid);
}
