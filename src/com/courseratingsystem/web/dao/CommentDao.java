package com.courseratingsystem.web.dao;

import java.util.List;

import com.courseratingsystem.web.domain.Comment;

public interface CommentDao {
	public void add(Comment comment);
	public void update(Comment comment);
	public void delete(Comment comment);
	public List<Comment> findCommentByCommentID(int commentid);
	public List<Comment> findCommentByUserID(final int userid);
	public List<Comment> findCommentByTeacherID(final int teacherid);
	public int getTotalCount();
	
	
	

}
