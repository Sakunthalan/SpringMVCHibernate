package com.niit.shop.shopback.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shop.shopback.dao.SupplierDao;
import com.niit.shop.shopback.model.Supplier;

@Repository("supplierdao")
@Transactional
public class SupplierImpl implements SupplierDao{

		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public boolean addSupplier(Supplier supplier) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.persist(supplier);
			session.getTransaction().commit();
			session.close();
			return true;
		}

		
		@Override
		public List<Supplier> supplierList() {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Supplier> list=session.createQuery("from Suppliers").list();
			session.getTransaction().commit();
			session.close();
			return list;
		}

		@Override
		public boolean deleteSupplier(Supplier supplier) {
		
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(supplier);
			session.getTransaction().commit();
			session.close();
			return true;
		}

		@Override
		public boolean updateSupplier(Supplier supplier) {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(supplier);
			session.getTransaction().commit();
			session.close();
			return true;
		}

		@Override
		public Supplier get(int id) {			
			return sessionFactory.getCurrentSession().get(Supplier.class, Integer.valueOf(id));
		}
			
}
