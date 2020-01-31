package com.itsy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itsy.model.Item;
import com.itsy.model.ItemReview;

@Repository
public interface ItemReviewDao extends JpaRepository<ItemReview, Integer> {

	public List<ItemReview> findByItem(Item item);
}
