package com.example.restApiDay1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApiDay1.service.LoginService;

@RestController
@RequestMapping("/v2")
public class AuthinicateController {
	@Autowired
	LoginService loginservice;
	
	@PostMapping("/authnticate/{id}/{username}")
	public String authnticateUsername(@PathVariable int id,@PathVariable String username) {
		String message=loginservice.fingByEmail(id,username);
		return message;
	}

}
