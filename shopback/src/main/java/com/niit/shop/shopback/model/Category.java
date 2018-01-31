package com.niit.shop.shopback.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="CategoryTable")
public class Category {

	@Id
	private String categoryId;
	private String categoryName;
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
