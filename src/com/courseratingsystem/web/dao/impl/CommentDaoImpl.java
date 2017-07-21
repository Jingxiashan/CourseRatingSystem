package com.courseratingsystem.web.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.courseratingsystem.web.dao.CommentDao;
import com.courseratingsystem.web.domain.Comment;

public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao{

	@Override
	public void add(Comment comment) {
		this.getHibernateTemplate().save(comment);
	}
	@Override
	public void update(Comment comment) {
		this.getHibernateTemplate().update(comment);		
	}
	@Override
	public void delete(Comment comment) {
		this.getHibernateTemplate().delete(this.findCommentByCommentID(comment.getCommentid()));		
	}

	@Override
	public List<Comment> findCommentByCourseID(int courseid) {
		List<Comment> commentList = getHibernateTemplate().find("from Comment where courseid = ?",courseid);
		return commentList;
	}
	@Override
	public List<Comment> findCommentByUserID(int userid) {
		List<Comment> commentList = getHibernateTemplate().find("from Comment where userid = ?", userid);
		return commentList;
	}
	@Override
	public Comment findCommentByCommentID(int commentid) {
		Comment comment =  this.getHibernateTemplate().get(Comment.class,commentid);
		return comment;
	}
	@Override
	public List<Comment> findCommentByTeacherID(final int teacherid) {
		List<Comment> commentList = getHibernateTemplate().find("from Comment where teacherid = ?", teacherid);
		return commentList;
	}

	@Override
	public int findCommentTotalCountByUserID(int userid) {
		Long count=(Long)this.getHibernateTemplate().find("select count(*) from Comment where userid = ?", userid).listIterator().next();
		return count.intValue();
	}
	@Override
	public int findCommentTotalCountByCourseID(int courseid) {
		Long count=(Long)this.getHibernateTemplate().find("select count(*) from Comment where courseid = ?", courseid).listIterator().next();
		return count.intValue();
	}
	@Override
	public int findCommentTotalCountByTeacherID(int teacherid) {
		Long count=(Long)this.getHibernateTemplate().find("select count(*) from Comment where teacherid = ?", teacherid).listIterator().next();
		return count.intValue();
	}
	
	@Override
	public int getTotalCount() {
		Long count=(Long)this.getHibernateTemplate().find("select count(*) from Comment").listIterator().next();
		return count.intValue();
	}


}
