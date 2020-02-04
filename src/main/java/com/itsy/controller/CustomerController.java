package com.itsy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itsy.model.Customer;
import com.itsy.model.Seller;
import com.itsy.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://itsyfrontend.s3-website.us-east-2.amazonaws.com")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer c ) {
		return service.addCustomer(c);
	}
	
	@PostMapping("/customer/login")
	public Customer validate(@RequestBody Customer customer) throws Exception {
		System.out.println("hitting customer/login");
		return service.validate(customer);
	}
}
