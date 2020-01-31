package com.itsy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsy.dao.SellerDao;
import com.itsy.model.Seller;

@Service
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	SellerDao sellerDao;

	@Override
	public List<Seller> getAllSellers() {
		return sellerDao.findAll();
	}

//	@Override
//	public Seller getSellerByName(String name) {
//		return sellerDao.findByName(name);
//	}

	@Override
	public Seller addSeller(Seller seller) {
		return sellerDao.save(seller);
	}

	@Override
	public Seller getSellerById(int id) {
		return sellerDao.findById(id).get();
	}
	
}
