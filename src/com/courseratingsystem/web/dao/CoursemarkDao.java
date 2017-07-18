package com.courseratingsystem.web.dao;

import com.courseratingsystem.web.domain.Coursemark;

public interface CoursemarkDao {
	public void add(Coursemark coursemark);
	public void update(Coursemark coursemark);
	public void findCoursemarkByCourseId(int courseid);
}
