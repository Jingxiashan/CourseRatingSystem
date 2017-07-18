package com.chinasoft.app.vo;

import java.util.List;

import com.chinasoft.app.hibernatejboss.Book;

public class BookPage {
	private int pageSize;
	private int currentPage;
	private int totalCount;
	private int totalPage;
	private List<Book> dataList;
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
	public List<Book> getDataList() {
		return dataList;
	}
	public void setDataList(List<Book> dataList) {
		this.dataList = dataList;
	}
	

}
