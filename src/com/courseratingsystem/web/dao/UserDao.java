package com.courseratingsystem.web.dao;

import java.util.List;

import com.courseratingsystem.web.domain.User;

public interface UserDao {
	public User add(User user);
	public void update(User user);
	public void delete(User user);
	public User findUserById(int userid);
	public List<User> findUserByNickname(final String nickname);
	public List<User> findUserByGrade(final String grade);
}
