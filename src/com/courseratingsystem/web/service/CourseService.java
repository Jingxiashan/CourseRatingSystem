package com.courseratingsystem.web.service;

import java.util.List;

import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.CourseOverview;
import com.courseratingsystem.web.vo.CoursePage;

public interface CourseService {
	public void add(Course course);
	public void update(Course course);
	public void delete(Course course);
	public CourseOverview findCourseOverviewById(int courseid);
	public Course findCourseById(final int courseid);
	public CoursePage findCourseByName(String coursename,String sortby,int currentPage,int pageSize);
	public CoursePage findAll(String sortby,int currentPage,int pageSize);
	public CoursePage findCourseByTeacher(String teachername,String sortby,int currentPage,int pageSize);
	public List<CourseOverview> Sort(List<CourseOverview> list,String sort);
	public CoursePage toPage(List<CourseOverview> list,int currentPage,int pageSize);
	}
