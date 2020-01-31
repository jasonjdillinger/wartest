package com.itsy.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.itsy.model.Item;
import com.itsy.model.ItemReview;
import com.itsy.model.Seller;
import com.itsy.model.SellerReview;

public interface ReviewService {
	public ItemReview addItemReview(ItemReview item);
	public List<ItemReview> getAllReviewsbyItem(Item item);
	public SellerReview addSellerReview(SellerReview seller);
	public List<SellerReview> getAllReviewsbySeller(Seller seller);
}
