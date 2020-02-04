package com.itsy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itsy.model.Item;
import com.itsy.model.Seller;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {

	public List<Item> findBySeller(Seller seller);

	public Item findByName(String name);

}
