package com.example.restApiDay1.validation;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.restApiDay1.dto.LoginDto;
@Component
@Lazy(true)//while running the bean will created when it is used otherwise it will stay lazy.it is for better performance
public class UsernameAndPasswordValidate {
	
	public boolean usernameValidate(LoginDto loginDto) {
		if( StringUtils.containsWhitespace(loginDto.getEmail())) {
			return true;
		}
		else if(  StringUtils.containsWhitespace(loginDto.getPassword()) || !loginDto.getPassword().matches(".*[!@#$%^&*()_+].*")) {
			return true;
		}
		return false;
	}
		
}


