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
	public Logininfo findLogininfoBycredentialsid(int credentialsid) {
		return this.getHibernateTemplate().get(Logininfo.class, credentialsid);
	}

	@Override
	public Logininfo findLogininfoByusername(final String username){
		Logininfo logininfo = (Logininfo) this.getHibernateTemplate().
				executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) 
					throws HibernateException,SQLException {
				Query query  = session.createQuery
						("from Logininfo where username = ?");
				query.setString(0, username);
				//List<Logininfo> list = query.list();
				Logininfo logininfo = (Logininfo)query.uniqueResult();
				return logininfo;
			}
		});
		return logininfo;
	}
	
	@Override
	public Logininfo findLogininfoByusernameandpassword
	(final String username,final String password) {
		Logininfo logininfo = (Logininfo) this.getHibernateTemplate().
				executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) 
					throws HibernateException,SQLException {
				Query query  = session.createQuery
						("from Logininfo where username = ? and password = ?");
				query.setString(0, username);
				query.setString(1, password);
				//List<Logininfo> list = query.list();
				Logininfo logininfo = (Logininfo)query.uniqueResult();
				return logininfo;
			}
		});
		return logininfo;
	}

}
