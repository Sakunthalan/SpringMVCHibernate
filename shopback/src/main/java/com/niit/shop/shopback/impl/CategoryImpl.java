package com.niit.shop.shopback.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shop.shopback.dao.CategoryDao;
import com.niit.shop.shopback.model.Category;

@Repository("categorydao")
@Transactional
public class CategoryImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public CategoryImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void insertCategory(Category category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(category);
		session.getTransaction().commit();
		session.close();
	}

}
