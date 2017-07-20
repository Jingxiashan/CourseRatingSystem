package com.courseratingsystem.web.service;

import java.util.List;

import com.courseratingsystem.web.domain.Comment;
import com.courseratingsystem.web.vo.CommentPage;

public interface CommentService {
	public void add(Comment comment);
	public void update(Comment comment);
	public void delete(Comment comment);
	public CommentPage findCommentByCommentID(int commentid,int currentPage,int pageSize,String sortmethod);
	public CommentPage findCommentByUserID(int userid,int currentPage,int pageSize,String sortmethod);
	public CommentPage findCommentByCourseID(int courseid,int currentPage,int pageSize,String sortmethod);
	public CommentPage findCommentByTeacherID(int teacherid,int currentPage,int pageSize,String sortmethod);
	public int getTotalCount();
	public void addLikeCount(Comment comment);
	public void Sort(List<Comment> commentList,String sortmethod);
}
