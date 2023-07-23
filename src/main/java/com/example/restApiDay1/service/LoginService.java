package com.example.restApiDay1.service;

import java.util.List;

import javax.validation.Valid;

import com.example.restApiDay1.dto.LoginDto;
import com.example.restApiDay1.dto.Message;
import com.example.restApiDay1.dto.UerInfoDto;
import com.example.restApiDay1.response.ClientResposeDto;



public interface LoginService {

	Message userLoginRegister(LoginDto loginDto);

	String deleteById(LoginDto loginDto);

	String fingByEmail(int id,String email);

	List<LoginDto> getAllRecord(int page,int limit);

	List<ClientResposeDto> getAllRecordByUserRoll(String roll);

	

	List<LoginDto> getAllRecords();

	
	
	


	

	

}
