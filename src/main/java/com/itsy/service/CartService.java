package com.itsy.service;

import java.util.List;

import com.itsy.model.Cart;
import com.itsy.model.Seller;

public interface CartService {
	
	public List<Cart> getAllCarts();
	public Cart addCart(Cart c);
	public Cart getCartById(int id);
	public Cart updateCart(Cart c );
	public void deleteCart(int id);
  
	
	public List<Cart> getCartsBySellerOrderByStatus(Seller seller);
	
}
