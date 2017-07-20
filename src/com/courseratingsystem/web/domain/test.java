package com.courseratingsystem.web.domain;

import com.courseratingsystem.web.dao.impl.CourseDaoImpl;

public class test {

	public static void main(String[] args) {
		CourseDaoImpl test = new CourseDaoImpl();
		CourseOverview course = test.findCourseOverviewByID(1);
		System.out.println(course.getCoursename()+course.getTeachername()+course.getAverageRatingsScoring());

	}

}
