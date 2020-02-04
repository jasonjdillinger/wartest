package com.itsy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsy.dao.SellerDao;
import com.itsy.model.Customer;
import com.itsy.model.Seller;

@Service
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	SellerDao sellerDao;

	@Override
	public List<Seller> getAllSellers() {
		return sellerDao.findAll();
	}

	@Override
	public Seller getSellerByName(String name) {
		return sellerDao.findByName(name);
	}
	
	@Override
	public Seller validate(Seller seller) throws Exception {
		System.out.println("Looking for seller.. " + seller.getName());
		
		Seller foundSeller = sellerDao.findByName(seller.getName());
		System.out.println("Found customer: " + foundSeller.getId() + ", " + foundSeller.getName());
		if(foundSeller == null) {
			System.out.println("Didn't find Seller..");
			throw new Exception("Invalid Credentials");
		}
		
		if(foundSeller.getPassword().equals(seller.getPassword())) {
			System.out.println("Found the correct Password..");
			return foundSeller;
		}
		
		System.out.println("Incorrect Password..");
		throw new Exception("Invalid Credentials");
	}

	@Override
	public Seller addSeller(Seller seller) {
		return sellerDao.save(seller);
	}

	@Override
	public Seller getSellerById(int id) {
		return sellerDao.findById(id).get();
	}
	
}
