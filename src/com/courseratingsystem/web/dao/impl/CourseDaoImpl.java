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

public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {

	@Override
	public void add(Course course) {
		this.getHibernateTemplate().save(course);

	}

	@Override
	public void update(Course course) {
		this.getHibernateTemplate().update(course);

	}

	@Override
	public void delete(Course course) {
		this.getHibernateTemplate().delete(course);

	}

	@Override
	public Course findCourseById(final int courseid){
		return this.getHibernateTemplate().get(Course.class, courseid);
	}
	
	@Override
	public CourseOverview findCourseOverviewByID(final int courseid) {
		String hql = ("select new com.courseratingsystem.web.domain.CourseOverview"
				+ "(c.courseid,c.coursename,m.averageRatingsUsefulness,m.averageRatingsVividness,m.averageRatingsSpareTimeOccupation,m.averageRatingsScoring,m.averageRatingsRollCall,m.peopleCount,m.recommendationScore,m.finalType) "
				+ "from Course c,Coursemark m where c.courseid=m.courseid and "
				+ "c.courseid=?");
		List<CourseOverview> tmpList = getHibernateTemplate().find(hql, courseid);
		return tmpList.isEmpty() ? null : tmpList.get(0);
		

		// CourseOverview course = (CourseOverview)
		// this.getHibernateTemplate().executeFind(new HibernateCallback() {
		// public Object doInHibernate(Session session) throws
		// HibernateException,SQLException {
		// String
		// hql=("select new com.courseratingsystem.web.domain.CourseOverview(c.courseid,c.coursename,t.teachername,"
		// +
		// "m.averageRatingsUsefulness,m.averageRatingsVividness,m.averageRatingsSpareTimeOccupation,m.averageRatingsScoring,"
		// +
		// "m.averageRatingsRollCall,m.peopleCount,m.recommendationScore,m.finalType) from Course c left outer join fetch c.teachers t inner join Coursemark m where"
		// + "c.courseid=?");
		// Query query = session.createQuery(hql);
		// query.setInteger(0, courseid);
		// CourseOverview course = (CourseOverview) query.uniqueResult();
		// return course;
		// }
		// });
		// return course;
	}

	@Override
	public List<CourseOverview> findCourseByName(final String coursename) {
		String hql = ("select new com.courseratingsystem.web.domain.CourseOverview"
				+ "(c.courseid,c.coursename,m.averageRatingsUsefulness,m.averageRatingsVividness,m.averageRatingsSpareTimeOccupation,m.averageRatingsScoring,m.averageRatingsRollCall,m.peopleCount,m.recommendationScore,m.finalType) "
				+ "from Course c,Coursemark m where c.courseid=m.courseid and "
				+ "c.coursename like ?");
		List<CourseOverview> list = getHibernateTemplate().find(hql,
				"%" + coursename + "%");
		return list;

		// List<CourseOverview> list = (List<CourseOverview>)
		// this.getHibernateTemplate().executeFind(new HibernateCallback() {
		// public Object doInHibernate(Session session) throws
		// HibernateException,SQLException {
		// String
		// hql=("select new com.courseratingsystem.web.domain.CourseOverview(c.courseid,c.coursename,t.teachername,"
		// +
		// "m.averageRatingsUsefulness,m.averageRatingsVividness,m.averageRatingsSpareTimeOccupation,m.averageRatingsScoring,"
		// +
		// "m.averageRatingsRollCall,m.peopleCount,m.recommendationScore,m.finalType) from Course c left outer join fetch c.teachers t inner join Coursemark m where"
		// + "c.coursename=?");
		// Query query = session.createQuery(hql);
		// query.setString(0, coursename);
		// List<CourseOverview> list =query.list();
		// return list;
		// }
		// });
		// return list;
	}

	@Override
	public List<CourseOverview> findAll() {
		String hql = ("select new com.courseratingsystem.web.domain.CourseOverview"
				+ "(c.courseid,c.coursename,m.averageRatingsUsefulness,m.averageRatingsVividness,m.averageRatingsSpareTimeOccupation,m.averageRatingsScoring,m.averageRatingsRollCall,m.peopleCount,m.recommendationScore,m.finalType) "
				+ "from Course c,Coursemark m where c.courseid=m.courseid");
		List<CourseOverview> list = getHibernateTemplate().find(hql, null);
		return list;
		// List<CourseOverview> list = (List<CourseOverview>)
		// this.getHibernateTemplate().executeFind(new HibernateCallback() {
		// public Object doInHibernate(Session session) throws
		// HibernateException,SQLException {
		// String
		// hql=("select new com.courseratingsystem.web.domain.CourseOverview(c.courseid,c.coursename,t.teachername,"
		// +
		// "m.averageRatingsUsefulness,m.averageRatingsVividness,m.averageRatingsSpareTimeOccupation,m.averageRatingsScoring,"
		// +
		// "m.averageRatingsRollCall,m.peopleCount,m.recommendationScore,m.finalType) from Course c left outer join fetch c.teachers t inner join Coursemark m");
		// Query query = session.createQuery(hql);
		// List<CourseOverview> list =query.list();
		// return list;
		// }
		// });
		// return list;
	}

	@Override
	public List<CourseOverview> findCourseByTeachername(String teachername) {
		String hql = ("select new com.courseratingsystem.web.domain.CourseOverview"
				+ "(c.courseid,c.coursename,m.averageRatingsUsefulness,m.averageRatingsVividness,m.averageRatingsSpareTimeOccupation,m.averageRatingsScoring,m.averageRatingsRollCall,m.peopleCount,m.recommendationScore,m.finalType) "
				+ "from Course c left join c.teachers t,Coursemark m where c.courseid=m.courseid and "
				+ "t.teachername like ?");
		List<CourseOverview> list = getHibernateTemplate().find(hql,
				"%" + teachername + "%");
		return list;
	}

	@Override
	public List<CourseOverview> findCourseByTeacherid(int teacherid) {
		String hql = ("select new com.courseratingsystem.web.domain.CourseOverview"
				+ "(c.courseid,c.coursename,m.averageRatingsUsefulness,m.averageRatingsVividness,m.averageRatingsSpareTimeOccupation,m.averageRatingsScoring,m.averageRatingsRollCall,m.peopleCount,m.recommendationScore,m.finalType) "
				+ "from Course c left join c.teachers t,Coursemark m where c.courseid=m.courseid and "
				+ "t.teacherid = ?");
		List<CourseOverview> list = getHibernateTemplate().find(hql,
				teacherid);
		return list;
	}

}
