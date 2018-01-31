package com.niit.shop.shopback.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shop.shopback.dao.UserDao;
import com.niit.shop.shopback.model.User;

@Repository
@Transactional
public class UserImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public UserImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insertUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
	}

}
