package com.courseratingsystem.web.service;

import com.courseratingsystem.web.domain.User;

public interface UserService {
	public void add(User user);
	public void update(User user);
	public void delete(User user);
	public User findUserById(int userid);
}
