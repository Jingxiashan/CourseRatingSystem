package com.courseratingsystem.web.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import com.courseratingsystem.web.dao.CommentDao;
import com.courseratingsystem.web.domain.Comment;
import com.courseratingsystem.web.service.CommentService;
import com.courseratingsystem.web.vo.CommentPage;

@Transactional
public class CommentServiceImpl implements CommentService{
	public static final String COMMENT_SORT_METHOD_BYLIKECOUNT = "bylikeCount";
	public static final String COMMENT_SORT_METHOD_BYTIME = "byTIME";
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
	public Comment findCommentByCommentID(int commentid) {
		return commentDao.findCommentByCommentID(commentid);
	}
	@Override
	public CommentPage findCommentByUserID(int userid,int currentPage,int pageSize,String sortmethod) {
		List<Comment> commentList = commentDao.findCommentByUserID(userid);
		if(!commentList.isEmpty()){
			Sort(commentList, sortmethod);		
			List<Comment> page = commentList.subList((currentPage - 1)*pageSize, commentList.size() < currentPage*pageSize ? commentList.size() : currentPage*pageSize);
			int totalCount = commentList.size();
			int totalPage = totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1;
			CommentPage commentPage = new CommentPage(pageSize, currentPage, totalCount, totalPage, page);
			return commentPage;
			}
		return null;
	}
	@Override
	public CommentPage findCommentByCourseID(int courseid,int currentPage,int pageSize,String sortmethod) {
		List<Comment> commentList = commentDao.findCommentByCourseID(courseid);
		if(!commentList.isEmpty()){
			Sort(commentList, sortmethod);		
			List<Comment> page = commentList.subList((currentPage - 1)*pageSize, commentList.size() < currentPage*pageSize ? commentList.size() : currentPage*pageSize);
			int totalCount = commentList.size();
			int totalPage = totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1;
			CommentPage commentPage = new CommentPage(pageSize, currentPage, totalCount, totalPage, page);
			return commentPage;
			}
		return null;
	}
	@Override
	public CommentPage findCommentByTeacherID(int teacherid,int currentPage,int pageSize,String sortmethod) {
		List<Comment> commentList = commentDao.findCommentByTeacherID(teacherid);
		if(!commentList.isEmpty()){
			Sort(commentList, sortmethod);		
			List<Comment> page = commentList.subList((currentPage - 1)*pageSize, commentList.size() < currentPage*pageSize ? commentList.size() : currentPage*pageSize);
			int totalCount = commentList.size();
			int totalPage = totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1;
			CommentPage commentPage = new CommentPage(pageSize, currentPage, totalCount, totalPage, page);
			return commentPage;
			}
		return null;
	}

	@Override
	public int getTotalCount() {
		return commentDao.getTotalCount();
	}

	@Override
	public int addLikeCount(int commentid) {
		Comment comment = commentDao.findCommentByCommentID(commentid);
		int likeCountNow = comment.getLikeCount();
		comment.setLikeCount(likeCountNow+1);
		commentDao.update(comment);
		return likeCountNow + 1;		
	}

	@Override
	public void Sort(List<Comment> commentList,final String sortmethod) {
		Collections.sort(commentList,new Comparator<Comment>(){
	
			@Override
			public int compare(Comment c1, Comment c2) {
				if(sortmethod.equals(COMMENT_SORT_METHOD_BYLIKECOUNT)){
					int i = c2.getLikeCount() - c1.getLikeCount();
					if(i==0){
						return c2.getTimestamp().compareTo(c1.getTimestamp());
					}
					return i;
				}
				return c2.getTimestamp().compareTo(c1.getTimestamp());
			}
		});
	}
}
