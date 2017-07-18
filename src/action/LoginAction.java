package com.chinasoft.app.action;

import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.chinasoft.app.hibernatejboss.DBUtil;
import com.chinasoft.app.hibernatejboss.User;
import com.chinasoft.app.hibernateutil.HibernateUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user=new User();
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String execute(){
		Session session=HibernateUtil.openSession();
		Transaction tran=session.beginTransaction();
		
		String hql="from User where username = ? and password = ?";
		Query query=session.createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		
		List<User> list=query.list();
		tran.commit();
		session.close();
		
		if(!list.isEmpty()){
			return "success";
		}
		else{
			return "fail";
		}
		
	}
	public String login(){
		if("admin".equals(user.getUsername())&&"123".equals(user.getPassword())){
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("username", user.getUsername());
			return "success";
		}
		Session session=HibernateUtil.openSession();
		Transaction tran=session.beginTransaction();
		
		String hql="from User where username = ? and password = ?";
		Query query=session.createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		
		List<User> list=query.list();
		tran.commit();
		session.close();
		
		if(!list.isEmpty()){
			return "success";
		}
		else{
			return "fail";
		}

		
		
		
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
