package com.itsy.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table
public class Seller extends User {

    // @OneToMany(fetch = FetchType.LAZY)
    // private List<Review> reviews;
    
}
