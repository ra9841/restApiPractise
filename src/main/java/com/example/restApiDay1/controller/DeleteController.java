package com.example.restApiDay1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApiDay1.dto.LoginDto;
import com.example.restApiDay1.service.LoginService;

@RestController
@RequestMapping("/v1")
public class DeleteController {
	@Autowired
	LoginService loginservice;
	
	@DeleteMapping("/deleteUser")
	public String deleteRecord(@RequestBody LoginDto loginDto) {
		String message=loginservice.deleteById(loginDto);
		return message;
	}
	
}
