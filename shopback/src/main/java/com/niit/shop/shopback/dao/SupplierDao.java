package com.niit.shop.shopback.dao;

import java.util.List;

import com.niit.shop.shopback.model.Supplier;

public interface SupplierDao {
	
	Supplier get(int id);
	List<Supplier> supplierList();
	boolean addSupplier(Supplier supplier);
	boolean deleteSupplier(Supplier supplier);
	boolean updateSupplier(Supplier supplier);
}
