package com.itsy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.itsy.model.Conversation;
import com.itsy.model.Customer;
import com.itsy.model.Seller;

@Repository
public interface ConversationDao extends JpaRepository<Conversation, Integer> {

	public List<Conversation> findByCustomer(Customer customer);
	public List<Conversation> findBySeller(Seller seller);
}
