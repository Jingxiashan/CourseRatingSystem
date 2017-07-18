package com.courseratingsystem.web.service;

import java.util.List;

import com.courseratingsystem.web.domain.User;

public interface UserService {
	public User signup(User user);
	public void setNickname(int userid, String nickname);
	public void setGrade(int userid, String grade);
	public User findUserById(int userid);
	public List<User> findUsersByNickname(String nickname);
	public List<User> findUsersByGrade(String grade);
}
