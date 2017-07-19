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
	public List<Comment> findCommentByCommentID(int commentid) {
		return (List<Comment>) this.getHibernateTemplate().get(Comment.class,commentid);

	}

	@Override
	public List<Comment> findCommentByUserID(final int userid) {
		List<Comment> commentList = getHibernateTemplate().find("from Comment where userid = ?", userid);
		return commentList;
	}

	@Override
	public List<Comment> findCommentByTeacherID(final int teacherid) {
		List<Comment> commentList = getHibernateTemplate().find("from Comment where teacherid = ?", teacherid);
		return commentList;
	}

	@Override
	public int getTotalCount() {
		Long count=(Long)this.getHibernateTemplate().find("select count(*) from Comment").listIterator().next();
		return count.intValue();
	}

	@Override
	public void addLikeCount(Comment comment) {
		comment.setLikeCount(comment.getLikeCount()+1);
		
	}

}
