package com.itsy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
//	@Temporal(value = TemporalType.TIMESTAMP)
	private Date sentDate;
	@OneToOne //(fetch = FetchType.LAZY) //keeping this eager because I'm paranoid. This will probably be ok to be Lazy, later.
	private User originator;
	private String contents;

}
