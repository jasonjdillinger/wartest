package com.itsy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itsy.model.Seller;
import com.itsy.model.SellerReview;

@Repository
public interface SellerReviewDao extends JpaRepository<SellerReview, Integer> {

	public List<SellerReview> findBySeller(Seller seller);
}
