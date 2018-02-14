package com.niit.shop.shopback.dao;

import java.util.List;

import com.niit.shop.shopback.model.Cart;

public interface CartDao {
	void insert(Cart cart);
	List<Cart> getCartByUserId(String userEmail); 
	Cart get(int cartId, String userEmail);
	void deleteCart(int cartId);
	void updateCart(Cart cart);
}
