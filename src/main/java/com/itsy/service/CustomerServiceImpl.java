package com.itsy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsy.dao.CustomerDao;
import com.itsy.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	@Override
	public Customer addCustomer(Customer c) {
		// TODO Auto-generated method stub
		return customerDao.save(c);
	}
	
	@Override
	public Customer validate(Customer customer) throws Exception {
		Customer foundCustomer = customerDao.findByName(customer.getName());
		System.out.println("Found customer: " + foundCustomer.getId() + ", " + foundCustomer.getName());
		if(foundCustomer == null) {
			System.out.println("Didn't find Customer..");
			throw new Exception("Invalid Credentials");
		}
		
		if(foundCustomer.getPassword().equals(customer.getPassword())) {
			System.out.println("Found the correct Password..");
			return foundCustomer;
		}
		
		System.out.println("Incorrect Password..");
		throw new Exception("Invalid Credentials");
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerDao.findById(id).get();
	}

	@Override
	public Customer updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return customerDao.save(c);
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerDao.deleteById(id);
	}

}
