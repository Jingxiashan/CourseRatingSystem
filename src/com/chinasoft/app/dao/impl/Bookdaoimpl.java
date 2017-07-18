package com.chinasoft.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.chinasoft.app.dao.BookDao;
import com.chinasoft.app.hibernatejboss.Book;
import com.chinasoft.app.hibernateutil.HibernateUtil;

public class Bookdaoimpl extends HibernateDaoSupport implements BookDao {

	@Override
//	public void add(Book book) {
//		// TODO Auto-generated method stub
//		Session session=HibernateUtil.openSession();
//		Transaction tran=session.beginTransaction();
//		session.save(book);
//		tran.commit();
//		session.close();	
//	}
	public void add(Book book){
		this.getHibernateTemplate().save(book);
	}

	@Override
//	public void update(Book book) {
//		// TODO Auto-generated method stub
//		Session session=HibernateUtil.openSession();
//		Transaction tran=session.beginTransaction();
//		session.update(book);
//		tran.commit();
//		session.close();
//	}
	public void update(Book book){
		this.getHibernateTemplate().update(book);
	}

	@Override
//	public void delete(Book book) {
//		// TODO Auto-generated method stub
//		Session session = HibernateUtil.openSession();
//		Transaction tran = session.beginTransaction();
//		session.delete(book);
//		tran.commit();
//		session.close();
//	}
	public void delete(int bookid){
		this.getHibernateTemplate().delete(this.findBookById(bookid));
	}

	@Override
//	public List<Book> findAll(int currentPage, int pageSize) {
//		// TODO Auto-generated method stub
//		Session session = HibernateUtil.openSession();
//		Query query=session.createQuery("from Book");
//		//set first rusult of each page
//		query.setFirstResult((currentPage-1)*pageSize);
//		query.setMaxResults(pageSize);
//		List<Book> list = query.list();
//		session.close();
//		return list;
//	}
	public List<Book> findAll(final int currentPage,final int pageSize){
		List list=this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException{
				Query query  = session.createQuery("from Book");
				query.setFirstResult(currentPage);
				query.setMaxResults(pageSize);
				List<Book> list = query.list();
				return list;
			}
		});
		return list;
	}

	@Override
//	public Book findBookById(int Bookid) {
//		// TODO Auto-generated method stub
//		Session session = HibernateUtil.openSession();
//		//get the book by current bookid
//		Book book=(Book) session.get(Book.class,Bookid);
//		session.close();
//		return book;
//	}
	public Book findBookById(int Bookid){
		return this.getHibernateTemplate().get(Book.class, Bookid);
	}

	@Override
//	public int findTotalCount() {
//		// TODO Auto-generated method stub
//		Session session = HibernateUtil.openSession();
//		Query query = session.createQuery("select count(*) from Book");
//		int count = Integer.parseInt(query.uniqueResult().toString());
//		return count;
//	}
	public int findTotalCount(){
		Long count=(Long)this.getHibernateTemplate().find("select count(*) from Book").listIterator().next();
		return count.intValue();
	}

}
