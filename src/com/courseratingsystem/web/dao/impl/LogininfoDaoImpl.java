package com.courseratingsystem.web.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.courseratingsystem.web.dao.LogininfoDao;
import com.courseratingsystem.web.domain.Logininfo;
import com.courseratingsystem.web.domain.User;

public class LogininfoDaoImpl extends HibernateDaoSupport implements LogininfoDao{

	@Override
	public void add(Logininfo logininfo) {
		this.getHibernateTemplate().save(logininfo);
	}

	@Override
	public void update(Logininfo logininfo) {
		this.getHibernateTemplate().update(logininfo);
	}

	@Override
	public void delete(Logininfo logininfo) {
		this.getHibernateTemplate().delete(logininfo);
	}

	@Override
	public List<Logininfo> findLogininfoByuser(final User user) {
		List<Logininfo> infoList = getHibernateTemplate().find("from Logininfo where userid = ?",user.getUserid());
		return infoList;
	}

	@Override
	public Logininfo findLogininfoByusername(final String username){
		List<Logininfo> infoList = getHibernateTemplate().find("from Logininfo where username = ?",username);
		return infoList.isEmpty() ? null : infoList.get(0);
	}
	
	@Override
	public Logininfo findLogininfoByusernameandpassword(final String username,final String password)
	 {
		List<Logininfo> infoList = getHibernateTemplate().find("from Logininfo where username = ? and password = ?", username, password);
		return infoList.isEmpty() ? null : infoList.get(0);
	}

}
