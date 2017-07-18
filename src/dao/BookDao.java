package com.chinasoft.app.dao;

import java.util.List;

import com.chinasoft.app.hibernatejboss.Book;


public interface BookDao {//define interface
	public void add(Book book);
	public void update(Book book);
	//public void delete(Book book);
	public void delete(int bookid);
	public List<Book> findAll(int currentPage,int pageSize);
	public Book findBookById(int Bookid);
	public int findTotalCount();
	

}
