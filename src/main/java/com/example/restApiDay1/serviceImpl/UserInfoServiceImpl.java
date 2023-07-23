package com.example.restApiDay1.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.restApiDay1.dto.LoginDto;
import com.example.restApiDay1.dto.UerInfoDto;
import com.example.restApiDay1.entity.ClientUserInfoEntity;
import com.example.restApiDay1.entity.LoginEntity;
import com.example.restApiDay1.entity.UserInfoEntity;
import com.example.restApiDay1.repository.ClientUserInfoRepository;
import com.example.restApiDay1.repository.UserInforepository;
import com.example.restApiDay1.response.ClientUserInfoResponseDto;
import com.example.restApiDay1.service.UserInfoService;

@Service
@Transactional

public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInforepository userInforepository;

	@Autowired
	LoginServiceImpl loginserviceimpl;// autowired boolean method from (to use method of other class we autowired)

	@Autowired
	ClientUserInfoRepository clientUserInfoRepository;

	@Override
	public String userLoginRegisterInfo(UerInfoDto userInfoDto) {

		UserInfoEntity userInfoEntity = new UserInfoEntity();// blank
		BeanUtils.copyProperties(userInfoDto, userInfoEntity);
		boolean userExistOrNot = loginserviceimpl.checkUserExst(userInfoEntity.getName());// calling metod
		if (userExistOrNot) {
			return "already exist";

		} else {

			userInfoEntity=	userInforepository.save(userInfoEntity);
			return "usersave";
		}
	}

	@Override
	public List<UerInfoDto> getAllRecordByCountry(String country) {

		List<UserInfoEntity> userInfoEntity = userInforepository.findByCountry(country);
		List<UerInfoDto> uerInfoDtoList = new ArrayList<>();// blank list

		for (UserInfoEntity gettingrecordbyCountry : userInfoEntity) {
			UerInfoDto allUserCountryInfo = new UerInfoDto();// blank
			BeanUtils.copyProperties(gettingrecordbyCountry, allUserCountryInfo);// copying
			uerInfoDtoList.add(allUserCountryInfo);
		}
		return uerInfoDtoList;
	}

	@Override
	public List<ClientUserInfoResponseDto> getAllRecordByCountryAndRoll(String country, String roll) {

		List<ClientUserInfoEntity> clientUserInfoEntity = clientUserInfoRepository.findByCountryAndRoll(country, roll);
		List<ClientUserInfoResponseDto> clientUserInfoResponseDtoList = new ArrayList<>();// blank list

		for (ClientUserInfoEntity gettingrecordbyCountryAndRoll : clientUserInfoEntity) {
			ClientUserInfoResponseDto allUserCountryAndRollInfo = new ClientUserInfoResponseDto();// blank
			BeanUtils.copyProperties(gettingrecordbyCountryAndRoll, allUserCountryAndRollInfo);// copying
			clientUserInfoResponseDtoList.add(allUserCountryAndRollInfo);
		}
		return clientUserInfoResponseDtoList;
	}

}
