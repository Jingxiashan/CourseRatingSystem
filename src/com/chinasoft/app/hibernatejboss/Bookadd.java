package com.chinasoft.app.hibernatejboss;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.chinasoft.app.hibernateutil.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Bookadd extends ActionSupport implements ModelDriven<Book>{
	private Book book=new Book();
	

	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}
	
	public String addBook(){
		Session session=HibernateUtil.openSession();
		Transaction tran=session.beginTransaction();		
		session.save(book);
		tran.commit();
		session.close();
		return "success";	
	}


	@Override
	public Book getModel() {
		// TODO Auto-generated method stub
		return book;
	}

}
