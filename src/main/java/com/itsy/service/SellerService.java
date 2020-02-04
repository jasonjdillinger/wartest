package com.itsy.service;

import java.util.List;

import com.itsy.model.Seller;

public interface SellerService {
	
	public List<Seller> getAllSellers();
	
	public Seller getSellerByName(String name);
	
	public Seller validate(Seller seller) throws Exception;
	
	public Seller getSellerById(int id);
	
	public Seller addSeller(Seller seller);

}
