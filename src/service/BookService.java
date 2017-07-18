package com.chinasoft.app.service;

import com.chinasoft.app.hibernatejboss.Book;
import com.chinasoft.app.vo.BookPage;

public interface BookService {
	public void add(Book book);
	public void update(Book book);
	//public void delete(Book book);
	public void delete(int bookid);
	public BookPage findAll(int currentPage,int pageSize);
	public Book findBookById(int Bookid);
	
	
}
