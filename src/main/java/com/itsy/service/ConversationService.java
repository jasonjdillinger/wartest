package com.itsy.service;

import java.util.List;

import com.itsy.model.Conversation;
import com.itsy.model.Customer;
import com.itsy.model.Message;
import com.itsy.model.Seller;
import com.itsy.model.User;

public interface ConversationService {
	public List<Message> getMessages(Conversation conversation);
	public List<Conversation> getConversationsbySeller(Seller u);
	public List<Conversation> getConversationsbyCustomer(Customer u);
	public Conversation addConversation(Conversation conversation);
	public Message addMessage(Message message);
}
