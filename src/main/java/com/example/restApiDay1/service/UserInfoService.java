package com.example.restApiDay1.service;

import java.util.List;

import javax.validation.Valid;

import com.example.restApiDay1.dto.UerInfoDto;
import com.example.restApiDay1.response.ClientUserInfoResponseDto;

public interface UserInfoService {

	String userLoginRegisterInfo(@Valid UerInfoDto userInfoDto);

	List<UerInfoDto> getAllRecordByCountry(String country);

	List<ClientUserInfoResponseDto> getAllRecordByCountryAndRoll(String country, String roll);



}
