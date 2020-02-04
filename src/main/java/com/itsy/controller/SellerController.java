package com.itsy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itsy.model.Cart;
import com.itsy.model.Seller;
import com.itsy.service.CartService;
import com.itsy.service.SellerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	@Autowired
	private CartService cartService;
	
	@GetMapping("/cart/seller/{seller}")
	public List<Cart>getCartsBySellerOrderByStatus(Seller seller) {
		return cartService.getCartsBySellerOrderByStatus(seller);
	}
	
	@PostMapping("/cart")
	public Cart addCart(@RequestBody Cart cart) {
		return cartService.addCart(cart);
	}

	@GetMapping("/seller")
	public List<Seller> getAllSellers() {
		return sellerService.getAllSellers();
	}

	@GetMapping("/seller/{id}")
	public Seller getSellerById(@PathVariable("id") int id) {
		return sellerService.getSellerById(id);
	}
	
	@GetMapping("/seller/{name}")
	public Seller getSellerByName(@PathVariable("name") String name) {
		return sellerService.getSellerByName(name);
	}

	@PostMapping("/seller")
	public Seller addSeller(@RequestBody Seller seller) {
		return sellerService.addSeller(seller);
	}
	
	@PostMapping("/seller/login")
	public Seller validate(@RequestBody Seller seller) throws Exception {
		System.out.println("Hit seller/login");
		return sellerService.validate(seller);
	}
}
