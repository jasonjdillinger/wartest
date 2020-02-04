package com.itsy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@NotEmpty(message = "The field is required.")
	private String name;
//	@Pattern(regexp="^\\d*(\\.\\d{2})?$")
	@Min(0)
	@NotNull(message = "The field is required.")
	private double price;
	@NotEmpty(message = "The field is required.")
	private String details;
	@ManyToOne
	private Seller seller;
	// @OneToMany(fetch = FetchType.LAZY)
	// private List<Review> reviews;
	
}
