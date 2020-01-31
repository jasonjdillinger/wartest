package com.itsy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsy.dao.ItemDao;
import com.itsy.dao.ItemReviewDao;
import com.itsy.dao.SellerReviewDao;
import com.itsy.model.Item;
import com.itsy.model.ItemReview;
import com.itsy.model.Seller;
import com.itsy.model.SellerReview;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ItemReviewDao itemReviewDao;
	@Autowired
	private SellerReviewDao sellerReviewDao;
	
	@Override
	public ItemReview addItemReview(ItemReview itemReview) {
		itemReview.setDate(new Date());
		return itemReviewDao.save(itemReview);
	}

	@Override
	public List<ItemReview> getAllReviewsbyItem(Item item) {
		return itemReviewDao.findByItem(item);
	}

	@Override
	public SellerReview addSellerReview(SellerReview sellerReview) {
		sellerReview.setDate(new Date());
		return sellerReviewDao.save(sellerReview);
	}

	@Override
	public List<SellerReview> getAllReviewsbySeller(Seller seller) {
		return sellerReviewDao.findBySeller(seller);
	}

}
