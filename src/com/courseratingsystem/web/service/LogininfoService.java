package com.courseratingsystem.web.service;

import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.domain.User;

public interface LogininfoService {
	public void add(Logininfo logininfo);
	public void update(Logininfo logininfo);
	public void delete(Logininfo logininfo);
	public Logininfo findLogininfoBycredentialsid(int credentialsid);
	public Logininfo findLogininfoByusername(String username,String password);
	public String login(String username,String password);
	public String register(User user,String username,String password);
	public String changepassword
		(User user,String oldpassword,String newpassword);
}
