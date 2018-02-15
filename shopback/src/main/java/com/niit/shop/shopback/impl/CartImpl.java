package com.niit.shop.shopback.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shop.shopback.dao.CartDao;
import com.niit.shop.shopback.model.Cart;
@Repository("cartdao")
@Transactional
public class CartImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insert(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(cart);
		session.getTransaction().commit();
		session.close();		
	}

	/*@Override
	@SuppressWarnings("unchecked")
	public List<Cart> getCartByUserId(String userEmail) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		List<Cart> list=session.createQuery("from CartTable where email=:email").setString("email",userEmail).getResultList();
		session.getTransaction().commit();
		session.close();
		return list;
	}*/
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cart> getCartByUserId(int userId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		List<Cart> list=session.createQuery("from CartTable where userId=:userId").setInteger("userId",userId).getResultList();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	/*@Override
	public Cart get(int cartId, String userEmail) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		Cart cart = (Cart) session.createQuery("from CartTable where email=:email and cartProductId=:id").setString("email",userEmail).setInteger("id",cartId).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return cart;
	}*/
	
	@Override
	public Cart get(int cartId, int userId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		Cart cart = (Cart) session.createQuery("from CartTable where userId=:userId and cartProductId=:id").setInteger("userId",userId).setInteger("id",cartId).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return cart;
	}

	@Override
	public void deleteCart(int cartId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Cart cart = (Cart)session.get(Cart.class, cartId);
		session.delete(cart);
		session.getTransaction().commit();
		session.close();		
	}

	@Override
	public void updateCart(Cart cart) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(cart);
		session.getTransaction().commit();
		session.close();		
	}

}
