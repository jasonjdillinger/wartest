package com.itsy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itsy.model.Seller;

@Repository
public interface SellerDao extends JpaRepository<Seller, Integer> {
	
//	public Seller findByName(String name);
	
}
