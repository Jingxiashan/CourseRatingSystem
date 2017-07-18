package com.courseratingsystem.web.service;

import java.util.List;

import com.courseratingsystem.web.domain.Comment;

public interface CommentService {
	public void add(Comment comment);
	public void update(Comment comment);
	public void delete(Comment comment);
	public List<Comment> findCommentByCommentID(int commentid);
	public List<Comment> findCommentByUserID(final int userid);
	public List<Comment> findCommentByTeacherID(final int teacherid);
	public int getTotalCount();
	public void addLikeCount(Comment comment);

}
