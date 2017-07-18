package com.courseratingsystem.web.service.impl;

import java.util.List;

import com.courseratingsystem.web.dao.UserDao;
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
	public User signup(User user) {
		return userDao.add(user);
	}

	@Override
	public void setNickname(int userid, String nickname) {
		User tmpUser = userDao.findUserById(userid);
		tmpUser.setNickname(nickname);
		userDao.update(tmpUser);
	}

	@Override
	public void setGrade(int userid, String grade) {
		User tmpUser = userDao.findUserById(userid);
		tmpUser.setGrade(grade);
		userDao.update(tmpUser);
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

}
