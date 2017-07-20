package com.courseratingsystem.web.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.courseratingsystem.web.dao.UserDao;
import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public User add(User user) {
		Serializable result = getHibernateTemplate().save(user);
		Integer userid = (Integer) result;
		return findUserById(userid.intValue());
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

	@Override
	public List<User> findUsersByNickname(final String nickname) { 
		List<User> userList = getHibernateTemplate().find("from User where nickname like ?", nickname);
		return userList;
		
//		List userList = getHibernateTemplate().executeFind(new HibernateCallback() {
//			@Override
//			public Object doInHibernate(Session session) throws HibernateException, SQLException {
//				String hql = "from User where nickname like ?";
//				Query query = session.createQuery(hql);
//				query.setString(0, "%"+nickname+"%");
//				return query.list();
//			}		
//		});
//		return userList;
	}

	@Override
	public List<User> findUsersByGrade(final String grade) {
		List<User> userList = getHibernateTemplate().find("from User where grade = ?", grade);
		return userList;
		
//		List userList = getHibernateTemplate().executeFind(new HibernateCallback() {
//			@Override
//			public Object doInHibernate(Session session) throws HibernateException, SQLException {
//				String hql = "from User where grade = ?";
//				Query query = session.createQuery(hql);
//				query.setString(0, grade);
//				return query.list();
//			}		
//		});
//		return userList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findFavourateCourseSet(int userid) {
		String hql = ("from Course c left outer join fetch c.users u where u.userid = ?");
		return getHibernateTemplate().find(hql, userid);
		
		
//		User tmpUser = getHibernateTemplate().get(User.class, userid);
//		getHibernateTemplate().initialize(tmpUser.getCourses());
//		Set<Course> favourateCourse = tmpUser.getCourses();
//		if(favourateCourse.size() == 0) {
//			return null;
//		}else{
//			List<Course> favourateList = new ArrayList<>();
//			Iterator<Course> iter = favourateCourse.iterator();
//			while(iter.hasNext()) {
//				favourateList.add(iter.next());
//			}
//			return favourateList;
//		}
				
	}
}
