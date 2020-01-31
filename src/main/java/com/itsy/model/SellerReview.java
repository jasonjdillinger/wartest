package com.itsy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Entity
@Table
public class SellerReview extends Review {
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public SellerReview(int id, Customer customer, double rating, String message, Date date, Seller seller) {
		super(id, customer, rating, message, date);
		this.seller = seller;
	}
	public SellerReview() {
		
	}
	@ManyToOne(fetch = FetchType.LAZY)
	private Seller seller;
	public String toString() {
		return super.toString()+" "+seller.getId();
	}
}
