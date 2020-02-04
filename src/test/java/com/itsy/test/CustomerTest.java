package com.itsy.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itsy.controller.CustomerController;
import com.itsy.model.Cart;
import com.itsy.model.Conversation;
import com.itsy.model.Customer;

@SpringBootTest
public class CustomerTest {
	
	@Autowired
	private CustomerController customerController;
	
	@Test
	public void assertControllerLoads() {
		assertNotNull(customerController);
	}
	
	@Test
	public void assertAddCustomerIsNotNull() {
		Customer customer = new Customer();
		customer.setCarts(new ArrayList<Cart>());
		customer.setConversations(new ArrayList<Conversation>());
		customer.setName("testCustomer");
		customer.setPassword("password");
		assertNotNull(customerController.addCustomer(customer));
	}
	
	@Test
	public void assertGetCustomerIsNotNull() {
		Customer customer = new Customer();
		customer.setCarts(new ArrayList<Cart>());
		customer.setConversations(new ArrayList<Conversation>());
		customer.setName("testCustomer");
		customer.setPassword("password");
		customerController.addCustomer(customer);
		assertNotNull(customerController.getAllCustomers());
	}
}