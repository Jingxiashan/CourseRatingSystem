package com.courseratingsystem.web.service;

import java.util.List;

import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.User;

public interface UserService {
	public User register(User user);
	public void update(User user);
	public User findUserById(int userid);
	public List<User> findUsersByNickname(String nickname);
	public List<User> findUsersByGrade(String grade);
	public List<Course> findFavouratesById(int userid);
	public void addFavourateCourse(int userid, Course course);
	public void deleteFavourateCourse(int userid, Course course);
	public boolean ifFavourate(int userid, Course course);
}
