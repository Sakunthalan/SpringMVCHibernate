package com.niit.shop.shopback.dao;

import java.util.List;

import com.niit.shop.shopback.model.Category;

public interface CategoryDao {
	Category get(String id);
	void insertCategory(Category category);
	List<Category> categoryList();
}
