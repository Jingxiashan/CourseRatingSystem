package com.courseratingsystem.web.dao;

import com.courseratingsystem.web.domain.User;

public interface UserDao {
	public void add(User user);
	public void update(User user);
	public void delete(User user);
	public User findUserById(int id);
}
