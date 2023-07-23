package com.example.restApiDay1.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstSecruityPractiseController {
	
	@GetMapping("/rabin")
	public String what() {
		return "welcome rabin";
	}
	@GetMapping("/pranaya")
	public String whatup() {
		return "welcome pranaya";
	}

	@GetMapping("/sonam")
	public String whatis() {
		return "welcome sonam";
	}

	@GetMapping("/sabin")
	public String whatUpIt() {
		return "welcome sabin";
	}


}
