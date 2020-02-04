package com.itsy.service;

import java.util.List;

import com.itsy.model.Item;
import com.itsy.model.Seller;

public interface ItemService {
	
	public List<Item> getAllItems();
	
	public List<Item> getAllItemsBySeller(Seller seller);

	public List<Item> getAllItemsFromList(List<Integer> ids);
	
	public Item getItemById(int id);

	public Item addItem(Item item);
	
	public Item updateItem(Item item);
	
	public void deleteItem(int id);

	public Item getItemByName(String name);
	
}
