package com.courseratingsystem.web.service;

import java.util.List;
import com.courseratingsystem.web.domain.Comment;

public interface CommentService {
	public void add(Comment comment);
	public void update(Comment comment);
	public void delete(Comment comment);
	public List<Comment> findCommentByCommentID(int commentid);
	public List<Comment> findCommentByUserID(int userid);
	public List<Comment> findCommentByCourseID(int courseid);
	public List<Comment> findCommentByTeacherID(int teacherid);
	public int getTotalCount();
	public void addLikeCount(Comment comment);
	public void sorting(List<Comment> commentList);
}
