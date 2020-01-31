package com.itsy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itsy.model.Item;
import com.itsy.model.ItemReview;
import com.itsy.model.Review;
import com.itsy.model.Seller;
import com.itsy.model.SellerReview;
import com.itsy.service.CustomerServiceImpl;
import com.itsy.service.ReviewService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping("/reviews/item/")
	public ItemReview addItemReview(@RequestBody ItemReview review) {
		return reviewService.addItemReview(review);
	}

	@GetMapping("/reviews/item/{item}")
	public List<ItemReview> getAllReviewsbyItem(@PathVariable("item") Item item) {
		return reviewService.getAllReviewsbyItem(item);
	}
	@PostMapping("/reviews/seller/")
	public SellerReview addSellerReview(@RequestBody SellerReview review) {
		review.setCustomer(new CustomerServiceImpl().getCustomerById(1));
		System.out.println(review.toString());
		return reviewService.addSellerReview(review);
	}

	@GetMapping("/reviews/seller/{seller}")
	public List<SellerReview> getAllReviewsbyItem(@PathVariable("seller") Seller seller) {
		return reviewService.getAllReviewsbySeller(seller);
	}
}
