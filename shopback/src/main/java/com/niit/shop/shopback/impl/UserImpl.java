package com.niit.shop.shopback.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shop.shopback.dao.UserDao;
import com.niit.shop.shopback.model.User;

@Repository("userdao")
@Transactional
public class UserImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public List<User> userList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<User> list=session.createQuery("from usertable").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

}
