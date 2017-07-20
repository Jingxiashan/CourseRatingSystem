package com.courseratingsystem.web.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.courseratingsystem.web.dao.UserDao;
import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User register(User user) {
		return userDao.add(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}


	@Override
	public User findUserById(int userid) {
		return userDao.findUserById(userid);
	}

	@Override
	public List<User> findUsersByNickname(String nickname) {
		return userDao.findUsersByNickname(nickname);
	}

	@Override
	public List<User> findUsersByGrade(String grade) {
		return userDao.findUsersByGrade(grade);
	}

	@Override
	public List<Course> findFavouratesById(int userid) {
		return userDao.findFavourateCourseSet(userid);
	}

	@Override
	public void addFavourateCourse(int userid, Course course) {
		User tmpUser = userDao.findUserById(userid);
		tmpUser.getCourses().add(course);
		userDao.update(tmpUser);
	}

}
