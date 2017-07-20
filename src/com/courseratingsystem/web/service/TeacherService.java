package com.courseratingsystem.web.service;

import java.util.List;

import com.courseratingsystem.web.domain.Teacher;

public interface TeacherService {
	public List<Teacher> findTeachersByTeachername(String teachername);
	public Teacher findTeacherByTeacherId(int teacherid);
	public List<Teacher> findTeachersByCourseID(int courseid);
}
