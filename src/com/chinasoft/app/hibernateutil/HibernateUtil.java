package com.chinasoft.app.hibernateutil;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Configuration configuration;
	public static SessionFactory sessionfactory;
	static{
		configuration=new Configuration().configure();
		sessionfactory=configuration.buildSessionFactory();
	}
	public static Session openSession(){
		return sessionfactory.openSession();
	}

}
