package com.chcraft.erdtojava.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	@GetMapping("/")
	public String hello() {
		return "hello world";
	}

	@GetMapping("/test")
	public String test() {
		return "Webhook build test";
	}
}
