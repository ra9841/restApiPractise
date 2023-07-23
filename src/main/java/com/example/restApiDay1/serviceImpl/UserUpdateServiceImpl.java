package com.example.restApiDay1.serviceImpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restApiDay1.dto.LoginDto;
import com.example.restApiDay1.dto.UerInfoDto;
import com.example.restApiDay1.entity.UserInfoEntity;
import com.example.restApiDay1.repository.UserUpdateRepository;
import com.example.restApiDay1.service.UserUpdateService;
@Service
@Transactional
public class UserUpdateServiceImpl implements UserUpdateService {
	
	@Autowired
	UserUpdateRepository userUpdateRepository;

	@Override
	public String updateUserDetailByNameId(UerInfoDto uerInfoDto, long nameId) {
		Optional<UserInfoEntity>existRecord=userUpdateRepository.findById(nameId);
		if(existRecord.isPresent()) {
			UserInfoEntity userInfoEntity= existRecord.get();
			userInfoEntity.setName(uerInfoDto.getName());
			userInfoEntity.setCountry(uerInfoDto.getCountry());
			userInfoEntity.setState(uerInfoDto.getState());
			userInfoEntity.setPhoneNumber(uerInfoDto.getPhoneNumber());
			
			userUpdateRepository.save(userInfoEntity); //to save on datbase
		    return "update successfully";
		}
		return "record is not present";
	}

}
