package com.courseratingsystem.web.object;

import java.util.List;

import com.courseratingsystem.web.domain.Teacher;

public class CourseOverviewPlusTeacher extends CourseOverview{
	List<Teacher> teacherList;
	public CourseOverviewPlusTeacher(CourseOverview tmpCourse) {
		super(tmpCourse);
	}
	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
}