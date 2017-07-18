package com.courseratingsystem.web.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.courseratingsystem.web.dao.CommentDao;
import com.courseratingsystem.web.domain.Comment;
import com.courseratingsystem.web.service.CommentService;

@Transactional
public class CommentServiceImpl implements CommentService{
	private CommentDao commentDao;

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	@Override
	public void add(Comment comment) {
		commentDao.add(comment);		
	}
	
	@Override
	public void update(Comment comment) {
		commentDao.update(comment);		
	}

	@Override
	public void delete(Comment comment) {
		commentDao.delete(comment);
		
	}

	@Override
	public List<Comment> findCommentByCommentID(int commentid) {
		return commentDao.findCommentByCommentID(commentid);
	}

	@Override
	public List<Comment> findCommentByUserID(int userid) {
		return commentDao.findCommentByUserID(userid);
	}

	@Override
	public List<Comment> findCommentByTeacherID(int teacherid) {
		return commentDao.findCommentByTeacherID(teacherid);
	}

	@Override
	public int getTotalCount() {
		return commentDao.getTotalCount();
	}

}
