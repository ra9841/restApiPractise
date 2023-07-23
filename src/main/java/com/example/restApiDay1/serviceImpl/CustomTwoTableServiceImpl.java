package com.example.restApiDay1.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.restApiDay1.entity.LoginEntity;
import com.example.restApiDay1.entity.UserInfoEntity;
import com.example.restApiDay1.repository.LoginRepository;
import com.example.restApiDay1.repository.UserInforepository;
import com.example.restApiDay1.response.ClientUserInfoResponseDto;
import com.example.restApiDay1.service.CustomTwoTableService;
@Component
public class CustomTwoTableServiceImpl implements CustomTwoTableService{
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	UserInforepository userInforepository;

	//for retreiving data from two table by autowiring two repository having two table class
	@Override
	public List<ClientUserInfoResponseDto> getAllRecordFromTwoTable() {
		List<UserInfoEntity>userInfoEntity=userInforepository.findAll();
		List<LoginEntity>loginEntity=loginRepository.findAll();
		List<ClientUserInfoResponseDto>clientUserInfoResponseDtoList=new ArrayList <>();
		
		for(UserInfoEntity dataFromUserInfotable:userInfoEntity) {
			ClientUserInfoResponseDto clientUserInfoResponseDto=new ClientUserInfoResponseDto();//blank
			if(dataFromUserInfotable.getCountry().equals("america")) {
			BeanUtils.copyProperties(dataFromUserInfotable, clientUserInfoResponseDto);
			
			clientUserInfoResponseDtoList.add(clientUserInfoResponseDto);
			}
		}
		for(LoginEntity dataFromloginTable:loginEntity) {
			ClientUserInfoResponseDto clientUserInfoResponseDto=new ClientUserInfoResponseDto();//blank
			
			BeanUtils.copyProperties(dataFromloginTable, clientUserInfoResponseDto);
			clientUserInfoResponseDtoList.add(clientUserInfoResponseDto);
		}
	
		return clientUserInfoResponseDtoList;
	}

}
