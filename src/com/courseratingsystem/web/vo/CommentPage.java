package com.courseratingsystem.web.vo;

import java.util.List;
import com.courseratingsystem.web.domain.Comment;

public class CommentPage {
	private int pageSize;//ÿҳ��ʾ����
	private int currentPage;//��ǰҳ
	private int totalCount;//������
	private int totalPage;
	//��ҳ����totalCount % pageSize == 0 ? 
	//totalCount / pageSize : totalCount / pageSize + 1
	private List<Comment> commentList;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Comment> getcommentList() {
		return commentList;
	}
	public void setDataList(List<Comment> commentList) {
		this.commentList = commentList;
	}
}
