package com.niit.shop.shopback.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shop.shopback.dao.ProductDao;
import com.niit.shop.shopback.model.Product;

@Repository("productdao")
@Transactional
public class ProductImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Product get(int id) { //also we can give string as param
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> productList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Product> list=session.createQuery("from ProductTable").list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Product> getProdByCategoryId(String categoryId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Product> list=session.createQuery("from ProductTable where categoryid=" + categoryId).list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public void deleteProduct(int pid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product prod = (Product)session.get(Product.class, pid);
		session.delete(prod);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateProduct(Product prod) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(prod);
		session.getTransaction().commit();
		session.close();
	}
}
