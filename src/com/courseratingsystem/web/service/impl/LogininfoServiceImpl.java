package com.courseratingsystem.web.service.impl;

import java.util.List;

import com.courseratingsystem.web.dao.LogininfoDao;
import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.domain.User;
import com.courseratingsystem.web.service.LogininfoService;

public class LogininfoServiceImpl implements LogininfoService{
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	private static final String ERROR = "error";
	private LogininfoDao logininfoDao;
	
	public void setLogininfodao(LogininfoDao logininfoDao) {
		this.logininfoDao = logininfoDao;
	}

	@Override
	public void add(Logininfo logininfo) {
		logininfoDao.add(logininfo);
	}

	public LogininfoDao getLogininfoDao() {
		return logininfoDao;
	}

	public void setLogininfoDao(LogininfoDao logininfoDao) {
		this.logininfoDao = logininfoDao;
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
		return logininfoDao.findLogininfoByuserid(user.getUserid());
	}

	@Override
	public Logininfo findLogininfoByusernameandpassword(String username, String password) {
		return logininfoDao.findLogininfoByusernameandpassword(username, password);
	}

	@Override

	public User login(Logininfo logininfo) {
		Logininfo tmpinfo = logininfoDao.findLogininfoByusernameandpassword(logininfo.getUsername(), logininfo.getPassword());
		if(tmpinfo != null) {
			//如果能查到相应的记录，则登陆成功
			return tmpinfo.getUser();
		}else {	
			//返回空值，无相应记录，返回失败
			return null;
		}
	}

	@Override
	public void register(User user,String username, String password) {
		Logininfo logininfo = new Logininfo();
		logininfo.setUser(user);
		logininfo.setUsername(username);
		logininfo.setPassword(password);
		logininfoDao.add(logininfo);
	}

	@Override
	public boolean changepassword(int userid,
			String oldpassword, String newpassword) {
		List<Logininfo> logininfolist = logininfoDao.findLogininfoByuserid(userid);
		String passwordInDB = logininfolist.get(0).getPassword();
		if(!passwordInDB.equals(oldpassword)){
			return false;
		}
		for(Logininfo logininfo:logininfolist){
			logininfo.setPassword(newpassword);
			logininfoDao.update(logininfo);
		}
		return true;
	}

	@Override
	public Logininfo findLogininfoByusername(String username) {
		return logininfoDao.findLogininfoByusername(username);
	}
}
