package com.banking.dao;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.banking.model.User;

@Service
@Repository
public class UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean saveUser(User user) {
		Session se=sessionFactory.openSession();
		Transaction tx=se.beginTransaction();
		se.save(user);
		tx.commit();
		se.close();
		return true;
	}
}