package com.itsy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConnectionController {
	
	@GetMapping("/")
	public String sayItsy() {
		return "Hello from Itsy";
	}

}
