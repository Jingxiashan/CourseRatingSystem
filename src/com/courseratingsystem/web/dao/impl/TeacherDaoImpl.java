package com.courseratingsystem.web.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.courseratingsystem.web.dao.TeacherDao;
import com.courseratingsystem.web.domain.Comment;
import com.courseratingsystem.web.domain.Course;
import com.courseratingsystem.web.domain.Teacher;

public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao {

	@Override
	public void add(Teacher teacher) {
		this.getHibernateTemplate().save(teacher);
	}
	@Override
	public void update(Teacher teacher) {
		this.getHibernateTemplate().update(teacher);
	}
	@Override
	public void delete(Teacher teacher) {
		this.getHibernateTemplate().delete(this.findTeacherByTeacherid(teacher.getTeacherid()));
	}

	@Override
	public List<Teacher> findTeachersByCourseID(int courseid) {
		String hql = ("from Teacher t left outer join fetch t.courses c where c.courseid = ?");
		return getHibernateTemplate().find(hql, courseid);
//		List list=this.getHibernateTemplate().executeFind(new HibernateCallback() {
//
//			@Override
//			public Object doInHibernate(Session session)
//					throws HibernateException, SQLException {
//				//get teacherid by courseid & store in query1.list()
//				String hql1="From Teaching where courseid = ?";
//				Query query1  = session.createQuery(hql1);
//				query1.setInteger(0, courseid);
//				String hql2="Form Teacher where teacherid = ?";
//				Query query2=session.createQuery(hql2);
//				for(int i=0;i<query1.list().size();i++){
//					//get teacher by teacherid & store in list
//					query2.setInteger(0, (int) query1.list().get(i));
//				}
//				List<Teacher> list = query2.list();
//				return list;
//			}
//			
//		});
//		return list;
	}

	@Override
	public Teacher findTeacherByTeacherid(int teacherid) {
		return this.getHibernateTemplate().get(Teacher.class, teacherid);
	}

	@Override
	public List<Teacher> findTeacherByTeachername(final String teachername) {
		List<Teacher> teacherlist = getHibernateTemplate().find("from Teacher where teachername like ?", teachername);
		return teacherlist;
		
//		List userList = getHibernateTemplate().executeFind(new HibernateCallback() {
//			@Override
//			public Object doInHibernate(Session session) throws HibernateException, SQLException {
//				String hql = "from Teacher where teachername like ?";
//				Query query = session.createQuery(hql);
//				query.setString(0, "%"+teachername+"%");
//				return query.list();
//			}		
//		});
//		return userList;
	}
	
}
