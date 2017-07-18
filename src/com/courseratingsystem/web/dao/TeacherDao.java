package com.courseratingsystem.web.dao;

import java.util.List;

import com.courseratingsystem.web.domain.Teacher;

public interface TeacherDao {
	public void add(Teacher teacher);
	public void update(Teacher teacher);
	public void delete(Teacher teacher);
	public Teacher findTeacherByTeacherid(int teacherid);
	public List<Teacher> findTeachersByCourseID(int courseid);

}
