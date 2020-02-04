package com.itsy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class ItemReview extends Review{
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull(message = "The field is required.")
	private Item item;
	public ItemReview(int id, Customer customer, double rating, String message, Date date, Item item) {
		super(id, customer, rating, message, date);
		this.item=item;
	}
}
