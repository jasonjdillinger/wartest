package com.itsy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsy.dao.ConversationDao;
import com.itsy.dao.MessageDao;
import com.itsy.model.Conversation;
import com.itsy.model.Customer;
import com.itsy.model.Message;
import com.itsy.model.Seller;
import com.itsy.model.User;

@Service
public class ConversationServiceImpl implements ConversationService {

	@Autowired
	private ConversationDao conversationDao;
	
	@Autowired
	private MessageDao messageDao;
	
	@Override
	public List<Message> getMessages(Conversation conversation) {
		return messageDao.findByConversation(conversation);
	}

	@Override
	public List<Conversation> getConversationsbyCustomer(Customer u) {
			return conversationDao.findByCustomer(u);
		}

	@Override
	public List<Conversation> getConversationsbySeller(Seller u) {
		return conversationDao.findBySeller(u);
	}
	
	@Override
	public Conversation addConversation(Conversation conversation) {
		return conversationDao.saveAndFlush(conversation);
	}
	@Override
	public Message addMessage(Message message) {
		return messageDao.save(message);
	}


}
