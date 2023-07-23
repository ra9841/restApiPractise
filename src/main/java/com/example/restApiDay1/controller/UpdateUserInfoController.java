package com.example.restApiDay1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApiDay1.dto.LoginDto;
import com.example.restApiDay1.dto.UerInfoDto;
import com.example.restApiDay1.service.UserUpdateService;

@RestController
@RequestMapping("/vupdate")
public class UpdateUserInfoController {
	@Autowired
	UserUpdateService userUpdateService;
	
	@PutMapping("/update/{nameId}")
	public String updateUserDetails(@RequestBody UerInfoDto uerInfoDto,@PathVariable long nameId) {
		String message=userUpdateService.updateUserDetailByNameId(uerInfoDto,nameId);
		return message;
	}

}
