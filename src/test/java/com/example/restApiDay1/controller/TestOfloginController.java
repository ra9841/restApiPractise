package com.example.restApiDay1.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.example.restApiDay1.dto.LoginDto;
import com.example.restApiDay1.dto.Message;
import com.example.restApiDay1.dto.UerInfoDto;
import com.example.restApiDay1.service.LoginService;
import com.example.restApiDay1.service.UserInfoService;
@ExtendWith(MockitoExtension.class)//for junit 5
@MockitoSettings(strictness=Strictness.LENIENT)
class TestOfloginController {
	@InjectMocks
	LoginController loginController;
	
	@Mock
	LoginService loginService;
	
	@Mock
	UserInfoService userInfoService;
	
	private LoginDto loginDto;
	
	
	@BeforeEach
	void init() {
		
		loginDto=new LoginDto();
		loginDto.setEmail("rabin");
		loginDto.setPassword("123");
	}
	
	

	@Test
	void testUserRegister() {
		//assert
		//when(loginService.userLoginRegister(any(LoginDto.class))).thenReturn();
		
		//act
		Message msg=loginController.userRegister(loginDto);
		
		//assert
		assertEquals("message",msg);
	}
	
	
	@Test
	void testUserRegisterInfo() {
		//assert
		UerInfoDto uerInfoDto=new UerInfoDto();
		uerInfoDto.setNameId(1);
		uerInfoDto.setName("rabin");
		uerInfoDto.setCountry("nepal");
		uerInfoDto.setState("bhaktapur");
		uerInfoDto.setPhoneNumber(1234);
		
		when(userInfoService.userLoginRegisterInfo(any(UerInfoDto.class))).thenReturn("usersave");
		
		//act
	//	String mesg=loginController.userRegisterInfo(uerInfoDto);
		
		//assert
		//assertNotNull(mesg);
		//assertEquals("usersave",mesg);
	}
	


}
