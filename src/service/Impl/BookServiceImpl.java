package com.chinasoft.app.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.chinasoft.app.dao.BookDao;
import com.chinasoft.app.dao.impl.Bookdaoimpl;
import com.chinasoft.app.hibernatejboss.Book;
import com.chinasoft.app.service.BookService;
import com.chinasoft.app.vo.BookPage;
@Transactional
public class BookServiceImpl implements BookService{
//	private BookDao bookDao=new Bookdaoimpl();
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub
		bookDao.add(book);

	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		bookDao.update(book);
		
	}

	@Override
//	public void delete(Book book) {
//		// TODO Auto-generated method stub
//		bookDao.delete(book);
//	}
	public void delete(int bookid){
		bookDao.delete(bookid);		
	}

	@Override
	public BookPage findAll(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		BookPage bookPage = new BookPage();
		List<Book> list = bookDao.findAll(currentPage, pageSize);
		
		bookPage.setDataList(list);
		bookPage.setCurrentPage(currentPage);
		bookPage.setPageSize(pageSize);
		
		int totalCount = bookDao.findTotalCount();
		bookPage.setTotalCount(totalCount);
		bookPage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		
		return bookPage;
	}

	@Override
	public Book findBookById(int Bookid) {
		// TODO Auto-generated method stub
		return bookDao.findBookById(Bookid);
	}

}
