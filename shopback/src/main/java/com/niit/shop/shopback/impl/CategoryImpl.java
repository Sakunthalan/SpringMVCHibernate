package com.niit.shop.shopback.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shop.shopback.dao.CategoryDao;
import com.niit.shop.shopback.model.Category;

@Repository("categorydao")
@Transactional
public class CategoryImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertCategory(Category category) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(category);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> categoryList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();		
		List<Category> list=session.createQuery("from CategoryTable").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public Category get(String id) {
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

}
