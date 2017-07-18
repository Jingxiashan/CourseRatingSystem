package com.chinasoft.app.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.chinasoft.app.hibernatejboss.Book;
import com.chinasoft.app.service.BookService;
import com.chinasoft.app.service.Impl.BookServiceImpl;
import com.chinasoft.app.vo.BookPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BookAction extends ActionSupport implements ModelDriven<Book>{
	private Book book=new Book();
	private int currentPage=1;
	private int pageSize=5;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	private BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public String add(){
		return null;
	}
	public String update(){
		bookService.update(book);
		return "book_search";
	}
	public String findById(){
		Book book1 = bookService.findBookById(book.getBookid());
		ServletActionContext.getRequest().setAttribute("book", book1);
		return "findById";
	}
//	public String delete(){
//		//bookService
//		Book book2 = bookService.findBookById(book.getBookid());
//		bookService.delete(book2);
//		return "book_search";
//	}
	public String delete(){
		bookService.delete(book.getBookid());
		return "book_search";
	}
	public String search(){
        BookPage bookPage = bookService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("bookPage", bookPage);
		return "success";
		
	}
	@Override
	public Book getModel() {
		// TODO Auto-generated method stub
		return book;
	}
	

}
