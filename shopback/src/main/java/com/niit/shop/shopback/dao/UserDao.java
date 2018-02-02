package com.niit.shop.shopback.dao;

import java.util.List;

import com.niit.shop.shopback.model.User;

public interface UserDao {
	void insertUser(User user);
	List<User> userList();
}
