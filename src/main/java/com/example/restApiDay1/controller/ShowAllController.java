package com.example.restApiDay1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApiDay1.dto.LoginDto;
import com.example.restApiDay1.dto.UerInfoDto;
import com.example.restApiDay1.response.ClientResposeDto;
import com.example.restApiDay1.response.ClientUserInfoResponseDto;
import com.example.restApiDay1.service.CustomTwoTableService;
import com.example.restApiDay1.service.LoginService;
import com.example.restApiDay1.service.UserInfoService;





@RestController
@RequestMapping("/v3")
public class ShowAllController {
	private static final Logger logger = LoggerFactory.getLogger(ShowAllController.class);
	
	@Autowired
	LoginService loginservice;
	
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	CustomTwoTableService customTwoTableService;
	
	@GetMapping("/shows")
	public List<LoginDto> ShowAllRecord(@RequestParam(value="page",defaultValue="0")int page,@RequestParam(value="limit",defaultValue="2")int limit) {
		List<LoginDto>getAlltheRecord=loginservice.getAllRecord(page,limit);
		logger.info("This is an informational message.");
		logger.warn("This is a warning message.");
		return getAlltheRecord;
		
		
	}
	@GetMapping("/show")
	public List<LoginDto> ShowAllRecords() {
		List<LoginDto>getAlltheRecord=loginservice.getAllRecords();
		return getAlltheRecord;
	}
	
	@GetMapping("/shows/{roll}")
	public List<ClientResposeDto> ShowAllRecordsByuserRoll(@PathVariable String roll) {
		List<ClientResposeDto>getAlltheRecord=loginservice.getAllRecordByUserRoll(roll);
		return getAlltheRecord;
	}
	
	@GetMapping("/showing/{country}")
	public List<UerInfoDto> ShowAllRecordsByCountry(@PathVariable String country) {
		List<UerInfoDto>getAlltheRecordByCountry=userInfoService.getAllRecordByCountry(country);
		return getAlltheRecordByCountry;
	}
	
	@GetMapping("/showall/{roll}/{country}")
	public List<ClientUserInfoResponseDto> ShowAllRecordsByCountryAndRoll(@PathVariable String country,@PathVariable String roll) {
	    List<ClientUserInfoResponseDto>getAlltheRecordByCountryAndRoll=userInfoService.getAllRecordByCountryAndRoll(country,roll);
		return getAlltheRecordByCountryAndRoll;
	}
	
	@GetMapping("/showAllCustom")
	public List<ClientUserInfoResponseDto> showAllFromTwoTable(){
		 List<ClientUserInfoResponseDto>getAlltheRecordByCountryAndRoll=customTwoTableService.getAllRecordFromTwoTable();
			return getAlltheRecordByCountryAndRoll;
	}

}
