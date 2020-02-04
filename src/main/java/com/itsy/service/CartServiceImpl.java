package com.itsy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsy.model.Seller;
import com.itsy.model.Status;
import com.itsy.dao.CartDao;
import com.itsy.model.Cart;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
  
	// used for seller-pending-orders || history-order
	@Override
	public List<Cart> getCartsBySellerOrderByStatus(Seller seller) {
		return cartDao.findBySellerOrderByStatusAsc(seller);
	}

	@Override
	public List<Cart> getAllCarts() {
		// TODO Auto-generated method stub
		return cartDao.findAll();
	}

	@Override
	public Cart addCart(Cart c) {
		// TODO Auto-generated method stub
		return cartDao.save(c);
	}

	@Override
	public Cart getCartById(int id) {
		// TODO Auto-generated method stub
		return cartDao.findById(id).get();
	}

	@Override
	public Cart updateCart(Cart c) {
		// TODO Auto-generated method stub
		return cartDao.save(c);
	}

	@Override
	public void deleteCart(int id) {
		// TODO Auto-generated method stub
		cartDao.deleteById(id);
	}

}
