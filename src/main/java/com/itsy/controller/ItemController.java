package com.itsy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itsy.model.Item;
import com.itsy.model.Seller;
import com.itsy.service.ItemService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/item")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}

	@GetMapping("/item/seller/{seller}")
	public List<Item> getAllItemsBySeller(@PathVariable("seller") Seller seller) {
		return itemService.getAllItemsBySeller(seller);
	}
	
	@GetMapping("/item/{id}")
	public Item getItemById(@PathVariable("id") int id) {
		return itemService.getItemById(id);
	}
	
	@GetMapping("/item/name/{name}")
	public Item getItemByName(@PathVariable("name") String name) {
		return itemService.getItemByName(name);
	}

	@PostMapping("/item")
	public Item addItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}

	@PutMapping("/item")
	public Item updateItem(@RequestBody Item item) {
		return itemService.updateItem(item);
	}

	@DeleteMapping("/item/{id}")
	public void deleteItem(@PathVariable("id") int id) {
		itemService.deleteItem(id);
	}

}
