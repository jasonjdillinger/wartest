package com.itsy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itsy.model.Status;

@Repository
public interface StatusDao extends JpaRepository<Status, Integer>{
}
