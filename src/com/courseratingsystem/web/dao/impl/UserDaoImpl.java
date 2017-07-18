package com.courseratingsystem.web.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.courseratingsystem.web.dao.UserDao;
import com.courseratingsystem.web.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public void add(User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	@Override
	public void delete(User user) {
		getHibernateTemplate().delete(user);		
	}

	@Override
	public User findUserById(int userid) {
		return getHibernateTemplate().get(User.class, userid);
	}
	
}
