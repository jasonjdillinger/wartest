package com.itsy.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
public class Customer extends User {
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Cart> carts;
	@OneToMany(fetch = FetchType.LAZY)
	List<Conversation> conversations;	

}
