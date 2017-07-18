package com.courseratingsystem.web.service.impl;

import java.util.List;

import com.courseratingsystem.web.dao.LogininfoDao;
import com.courseratingsystem.web.dao.impl.LogininfoDaoImpl;
import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.LogininfoService;

public class LogininfoServiceImpl implements LogininfoService{
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
	public List<Logininfo> findLogininfoByuser(User user) {
		return logininfoDao.findLogininfoByuser(user);
	}

	@Override
	public Logininfo findLogininfoByusernameandpassword(String username, String password) {
		return logininfoDao.findLogininfoByusernameandpassword(username, password);
	}

	@Override
	public String login(String username, String password) {
		Logininfo logininfo = logininfoDao.findLogininfoByusernameandpassword(username, password);
		if(logininfo!=null)
			return "success";
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
		return "success";
	}

	@Override
	public String changepassword(User user,
			String oldpassword, String newpassword) {
		List<Logininfo> logininfolist = logininfoDao.findLogininfoByuser(user);
		if(logininfolist.get(0).getPassword()!=oldpassword){
			return "error";
		}
		for(Logininfo logininfo:logininfolist){
			logininfo.setPassword(newpassword);
			logininfoDao.update(logininfo);
		}
		return "success";
	}
}
