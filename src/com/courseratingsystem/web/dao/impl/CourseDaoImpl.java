package com.courseratingsystem.web.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.courseratingsystem.web.dao.CourseDao;
import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.CourseOverview;

public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao{

	@Override
	public void add(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CourseOverview findCourseByID(final int courseid) {
		CourseOverview course = (CourseOverview) this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				String hql=("select new com.courseratingsystem.web.domain.CourseOverview(c.courseid,c.coursename,t.teachername,"
						+ "m.averageRatingsUsefulness,m.averageRatingsVividness,m.averageRatingsSpareTimeOccupation,m.averageRatingsScoring,"
						+ "m.averageRatingsRollCall,m.peopleCount,m.recommendationScore,m.finalType) from course c, teacher t, coursemark m,teaching g where c.courseid=g.courseid and t.teacherid=g.teacherid and"
						+ "c.courseid=m.courseid c.courseid=?");
				Query query  = session.createQuery(hql);
				query.setInteger(0, courseid);
				CourseOverview course = (CourseOverview) query.uniqueResult();
				return course;
			}
		});
		return course;
	}

	@Override
	public List<CourseOverview> findCourseByName(String coursename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseOverview> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
