package com.itsy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.itsy.model.Cart;
import com.itsy.model.Conversation;
import com.itsy.model.Customer;
import com.itsy.model.Item;
import com.itsy.model.Message;
import com.itsy.model.Seller;
import com.itsy.model.Status;
import com.itsy.service.ItemServiceImpl;
import com.itsy.service.SellerServiceImpl;
import com.itsy.service.StatusService;
import com.itsy.model.Customer;
import com.itsy.service.CartServiceImpl;
import com.itsy.service.ConversationServiceImpl;
import com.itsy.service.CustomerServiceImpl;

@SpringBootApplication
public class ItsyBackendApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ItsyBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner sellerDemoData(SellerServiceImpl sellerService, ItemServiceImpl itemService, 
			CustomerServiceImpl customerService, CartServiceImpl cartService, StatusService statusService,
			ConversationServiceImpl conversationService) {
		return args -> {
			System.out.println("Generating the Seller info..");
			Seller seller;
			int id = 1;

			seller = new Seller();
			seller.setName(id++ + "_namio");
			seller.setPassword("password");
			sellerService.addSeller(seller);
			seller = new Seller();
			seller.setName(id++ + "_namio");
			seller.setPassword("password");
			sellerService.addSeller(seller);
			
			System.out.println("Generating Status info...");
			Status status;
			status = new Status();
			status.setAddedToCart(null);
			status.setOrdered(null);
			status.setShipped(null);
			statusService.addStatus(status);			
      
			System.out.println("Generating the Customer info...");
			Customer customer;
			int cid = 1;
			customer = new Customer();
			customer.setCarts(new ArrayList<Cart>());
			customer.setConversations(new ArrayList<Conversation>());
			customer.setName(cid++ + "customer");
			customer.setPassword("password");
			customerService.addCustomer(customer);
			customer = new Customer();
			customer.setCarts(new ArrayList<Cart>());
			customer.setConversations(new ArrayList<Conversation>());
			customer.setName(cid++ + "customer");
			customer.setPassword("password");
			customerService.addCustomer(customer);
			customer = new Customer();
			customer.setCarts(new ArrayList<Cart>());
			customer.setConversations(new ArrayList<Conversation>());
			customer.setName(cid++ + "customer");
			customer.setPassword("password");
			customerService.addCustomer(customer);

			System.out.println("Generating the Item info..");
			seller = sellerService.getAllSellers().get(0);
			Item item;
			id = 6;

			item = new Item();
			item.setDetails("Details of item: " + (id));
			item.setName("Name" + (id));
			item.setPrice(id++);
			item.setSeller(seller);
			itemService.addItem(item);
			item = new Item();
			item.setDetails("Details of item: " + (id));
			item.setName("Name" + (id));
			item.setPrice(id++);
			item.setSeller(seller);
			itemService.addItem(item);
			item = new Item();
			item.setDetails("Details of item: " + (id));
			item.setName("Name" + (id));
			item.setPrice(id++);
			item.setSeller(seller);
			itemService.addItem(item);
			item = new Item();
			item.setDetails("Details of item: " + (id));
			item.setName("Name" + (id));
			item.setPrice(id++);
			item.setSeller(seller);
			itemService.addItem(item);
			item = new Item();
			item.setDetails("Details of item: " + (id));
			item.setName("Name" + (id));
			item.setPrice(id++);
			item.setSeller(seller);
			itemService.addItem(item);
			
			System.out.println("Generating Cart info...");
			Cart cart;
			cart = new Cart();
			Map<Item, Integer> itemMap = new HashMap<Item, Integer>();
			itemMap.put(item, 1);
			//cart.setItems(itemMap);
			cart.setSeller(seller);
			cart.setStatus(status);
			List<Cart> carts = new ArrayList<Cart>();
			carts.add(cart);
			cartService.addCart(cart);
			System.out.println("Generating the Customer info...");
			//Customer customer;
			//int cid = 1;
			customer = new Customer();
			customer.setCarts(carts);
			customer.setConversations(new ArrayList<Conversation>());
			customer.setName(cid++ + "customer");
			customer.setPassword("password");
			customerService.addCustomer(customer);
			customer = new Customer();
			customer.setCarts(null);
			customer.setConversations(new ArrayList<Conversation>());
			customer.setName(cid++ + "customer");
			customer.setPassword("password");
			customerService.addCustomer(customer);
			customer = new Customer();
			customer.setCarts(null);
			customer.setConversations(new ArrayList<Conversation>());
			customer.setName("myCustomer");
			customer.setPassword("password");
			customerService.addCustomer(customer);
			
			Conversation c=new Conversation();
			c.setCustomer(customer);
			c.setRead(true);
			c.setSeller(seller);
			conversationService.addConversation(c);
			
			Message m = new Message();
			m.setContents("fff");
			m.setConversation(c);
			m.setOriginator(customer);
			m.setSentDate(new Date());
			conversationService.addMessage(m);
			m = new Message();
			m.setContents("fff");
			m.setConversation(c);
			m.setOriginator(seller);
			m.setSentDate(new Date());
			conversationService.addMessage(m);
		};
	}

}
