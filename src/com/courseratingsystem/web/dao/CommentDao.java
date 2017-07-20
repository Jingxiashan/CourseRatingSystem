package com.courseratingsystem.web.dao;

import java.util.List;
import com.courseratingsystem.web.domain.Comment;

public interface CommentDao {
	public void add(Comment comment);
	public void update(Comment comment);
	public void delete(Comment comment);
	
	public List<Comment> findCommentByCommentID(int commentid);
	public List<Comment> findCommentByUserID(int userid);
	public List<Comment> findCommentByCourseID(int courseid);
	public List<Comment> findCommentByTeacherID(int teacherid);
	
	public int findCommentTotalCountByUserID(int userid);
	public int findCommentTotalCountByCourseID(int courseid);
	public int findCommentTotalCountByTeacherID(int teacherid);
	
	public int getTotalCount();
	public void addLikeCount(Comment comment);
}
