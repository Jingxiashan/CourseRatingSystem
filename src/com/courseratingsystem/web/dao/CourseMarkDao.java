package com.courseratingsystem.web.dao;

import java.util.List;

import com.courseratingsystem.web.domain.Coursemark;

public interface CourseMarkDao {
	public void add(Coursemark coursemark);
	public void update (Coursemark coursemark);
	public void delete (Coursemark coursemark);
	public Coursemark findCoursemarkByID(int courseid);
}
