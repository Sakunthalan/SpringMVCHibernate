package com.niit.shop.shopback.dao;

import java.util.List;

import com.niit.shop.shopback.model.Product;

public interface ProductDao {
	void insertProduct(Product product);
	Product get(int id);
	List<Product> productList();
}
