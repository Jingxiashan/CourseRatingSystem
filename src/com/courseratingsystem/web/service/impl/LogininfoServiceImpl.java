package com.courseratingsystem.web.service.impl;

import com.courseratingsystem.web.dao.LogininfoDao;
import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.LogininfoService;

public class LogininfoServiceImpl implements LogininfoService{
	private static final String SUCCESS = null;
	private LogininfoDao logininfoDao;
	
	public void setLogininfodao(LogininfoDao logininfoDao) {
		this.logininfoDao = logininfoDao;
	}

	@Override
	public void add(Logininfo logininfo) {
		logininfoDao.add(logininfo);
	}

	@Override
	public void update(Logininfo logininfo) {
		logininfoDao.update(logininfo);
	}

	@Override
	public void delete(Logininfo logininfo) {
		logininfoDao.delete(logininfo);
	}

	@Override
	public Logininfo findLogininfoBycredentialsid(int credentialsid) {
		return logininfoDao.findLogininfoBycredentialsid(credentialsid);
	}

	@Override
	public Logininfo findLogininfoByusername(String username, String password) {
		return logininfoDao.findLogininfoByusernameandpassword(username, password);
	}

	@Override
	public String login(String username, String password) {
		Logininfo logininfo = logininfoDao.findLogininfoByusernameandpassword(username, password);
		if(logininfo!=null)
			return SUCCESS;
		return "fail";
	}

	@Override
	public String register(User user,String username, String password) {
		Logininfo logininfo = logininfoDao.findLogininfoByusername(username);
		if(logininfo!=null){
			return "fail";
		}
		logininfo.setUser(user);
		logininfo.setUsername(username);
		logininfo.setPassword(password);
		logininfoDao.add(logininfo);
		return SUCCESS;
	}

	@Override
	public String changepassword(User user,
			String oldpassword, String newpassword) {
		// TODO Auto-generated method stub
		return null;
	}
}
