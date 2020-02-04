package com.itsy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itsy.model.Conversation;
import com.itsy.model.Message;

@Repository
public interface MessageDao extends JpaRepository<Message, Integer> {
	public List<Message> findByConversation(Conversation c);
}
