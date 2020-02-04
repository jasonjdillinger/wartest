package com.itsy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.InheritanceType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull(message = "The field is required.")
	private Customer customer;
	@Min(0)
	@Max(5)
	@NotNull(message = "The field is required.")
	private double rating;
	@NotEmpty(message = "The field is required.")
	private String message;
	private Date date;

}
