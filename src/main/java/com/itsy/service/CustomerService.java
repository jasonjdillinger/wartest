package com.itsy.service;

import java.util.List;

import com.itsy.model.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer addCustomer(Customer c);
	public Customer getCustomerById(int id);
	public Customer updateCustomer(Customer c );
	public void deleteCustomer(int id);
}
