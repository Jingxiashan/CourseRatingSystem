package com.courseratingsystem.web.service.impl;

import com.courseratingsystem.web.dao.LogininfoDao;
import com.courseratingsystem.web.domain.Logininfo;
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
	public Logininfo findLogininfoBycredentialsid(int credentialsid) {
		return logininfoDao.findLogininfoBycredentialsid(credentialsid);
	}

	@Override
	public Logininfo findLogininfoByusername(String username, String password) {
		return logininfoDao.findLogininfoByusername(username, password);
	}
}
