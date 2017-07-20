package com.courseratingsystem.web.service.impl;

import java.util.List;

import com.courseratingsystem.web.dao.TeacherDao;
import com.courseratingsystem.web.domain.Teacher;
import com.courseratingsystem.web.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{
	private TeacherDao teacherDao;

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	@Override
	public List<Teacher> findTeachersByTeachername(String teachername) {
		return teacherDao.findTeacherByTeachername(teachername);
	}

	@Override
	public Teacher findTeacherByTeacherId(int teacherid) {
		return teacherDao.findTeacherByTeacherid(teacherid);
	}
	@Override
	public List<Teacher> findTeachersByCourseID(int courseid) {
		return teacherDao.findTeachersByCourseID(courseid);		
	}

}
