package com.itsy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.itsy.model.Cart;
import com.itsy.model.Conversation;
import com.itsy.model.Item;
import com.itsy.model.ItemReview;
import com.itsy.model.Review;
import com.itsy.model.Seller;
import com.itsy.model.SellerReview;
import com.itsy.service.ItemServiceImpl;
import com.itsy.service.ReviewServiceImpl;
import com.itsy.service.SellerServiceImpl;
import com.itsy.model.Customer;
import com.itsy.service.CustomerServiceImpl;

@SpringBootApplication
public class ItsyBackendApplication extends SpringBootServletInitializer{

	public static void main(String[] args)  {
		SpringApplication.run(ItsyBackendApplication.class, args);//lol
	}
	

	@Bean
	public CommandLineRunner sellerDemoData(SellerServiceImpl sellerService, ItemServiceImpl itemService, CustomerServiceImpl customerService, ReviewServiceImpl reviewService) {
		return args -> {
			System.out.println("Generating the Customer info...");
			Customer customer;
			int cid = 1;
			customer = new Customer();
			//customer.setCarts(new ArrayList<Cart>());
			customer.setConversations(new ArrayList<Conversation>());
			customer.setName(cid++ + "customer");
			customer.setPassword("password");
			customerService.addCustomer(customer);
			customer = new Customer();
			//customer.setCarts(new ArrayList<Cart>());
			customer.setConversations(new ArrayList<Conversation>());
			customer.setName(cid++ + "customer");
			customer.setPassword("password");
			customerService.addCustomer(customer);
			customer = new Customer();
			//customer.setCarts(new ArrayList<Cart>());
			customer.setConversations(new ArrayList<Conversation>());
			customer.setName(cid++ + "customer");
			customer.setPassword("password");
			customerService.addCustomer(customer);
			
			System.out.println("Generating the Seller info..");
			Seller seller;
			int id = 1;

			seller = new Seller();
			seller.setName(id++ + "_namio");
			seller.setPassword("password");
			seller.setConversations(new ArrayList<Conversation>());
			sellerService.addSeller(seller);
			SellerReview sellerreview=new SellerReview(seller);
			sellerreview.setId(1);
			sellerreview.setCustomer(customer);
			sellerreview.setRating(3);
			sellerreview.setMessage("this thing sucks");
			sellerreview.setDate(new Date());
			sellerreview.setSeller(seller);
			reviewService.addSellerReview(sellerreview);
			seller = new Seller();
			seller.setName(id++ + "_namio");
			seller.setPassword("password");
			seller.setConversations(new ArrayList<Conversation>());
			sellerService.addSeller(seller);
			seller = new Seller();
			seller.setName(id++ + "_namio");
			seller.setPassword("password");
			seller.setConversations(new ArrayList<Conversation>());
			sellerService.addSeller(seller);
			
			//seller.setReviews(reviews);		
			
			
			System.out.println("Generating the Item info..");
			seller = sellerService.getAllSellers().get(0);
			Item item;
			byte[] image = { 0b00000000, 0b00000001, 0b00000001, 0b00000001 };

			item = new Item();
			item.setDetails("Details of item: " + (id));
			item.setImage(image);
			item.setName("Name" + (id));
			item.setPrice(id++);
			item.setSeller(seller);
			itemService.addItem(item);
			item = new Item();
			item.setDetails("Details of item: " + (id));
			item.setImage(image);
			item.setName("Name" + (id));
			item.setPrice(id++);
			item.setSeller(seller);
			itemService.addItem(item);
			item = new Item();
			item.setDetails("Details of item: " + (id));
			item.setImage(image);
			item.setName("Name" + (id));
			item.setPrice(id++);
			item.setSeller(seller);
			itemService.addItem(item);
			item = new Item();
			item.setDetails("Details of item: " + (id));
			item.setImage(image);
			item.setName("Name" + (id));
			item.setPrice(id++);
			item.setSeller(seller);
			itemService.addItem(item);
			item = new Item();
			item.setDetails("Details of item: " + (id));
			item.setImage(image);
			item.setName("MyTest");
			item.setPrice(id++);
			item.setSeller(seller);
			List<ItemReview> itemreviews=new ArrayList<ItemReview>();
			
			//item.setReviews(itemreviews);
			itemService.addItem(item);
			ItemReview itemreview=new ItemReview();
			itemreview.setItem(item);
			itemreview.setId(1);
			itemreview.setCustomer(customer);
			itemreview.setRating(3);
			itemreview.setMessage("this thing sucks");
			itemreview.setDate(new Date());
			itemreviews.add(itemreview);
			reviewService.addItemReview(itemreview);
		};
	}

}
