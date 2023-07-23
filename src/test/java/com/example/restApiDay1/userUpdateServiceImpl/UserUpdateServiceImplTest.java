package com.example.restApiDay1.userUpdateServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.example.restApiDay1.dto.UerInfoDto;
import com.example.restApiDay1.entity.UserInfoEntity;
import com.example.restApiDay1.repository.UserUpdateRepository;
import com.example.restApiDay1.serviceImpl.UserUpdateServiceImpl;

@ExtendWith(MockitoExtension.class) // for junit 5
@MockitoSettings(strictness = Strictness.LENIENT)
class UserUpdateServiceImplTest {

	@InjectMocks
	UserUpdateServiceImpl userUpdateServiceImpl;

	@Mock
	UserUpdateRepository userUpdateRepository;
	
	UerInfoDto uerInfoDto = new UerInfoDto();
	
	UserInfoEntity userInfoEntity = new UserInfoEntity();
	
	@BeforeEach
	void init() {
		uerInfoDto.setNameId(1);
		uerInfoDto.setName("rabin");
		uerInfoDto.setCountry("nepal");
		uerInfoDto.setState("bhaktapur");
		uerInfoDto.setPhoneNumber(12345);
	}

	@Test
	void testupdateUserDetailByNameId() {
		// arrange
		long nameId=2l;
	
		

		
		/*
		 * userInfoEntity.setNameId(1); userInfoEntity.setName("hari");
		 * userInfoEntity.setCountry("america"); userInfoEntity.setState("california");
		 * userInfoEntity.setPhoneNumber(23456);
		 */

		when(userUpdateRepository.findById(anyLong())).thenReturn(Optional.of(userInfoEntity));
		when(userUpdateRepository.save(userInfoEntity)).thenReturn(userInfoEntity);
		// act
		String msg = userUpdateServiceImpl.updateUserDetailByNameId(uerInfoDto,nameId);
		// assert
	    assertEquals("update successfully", msg);
	    assertEquals("rabin",userInfoEntity.getName());
	    assertEquals("nepal",userInfoEntity.getCountry());
	

	}
	
	
	@Test
	void testupdateUserDetailByNameIdIfEmpty() {
		// arrange
		long nameId=1l;
		//UerInfoDto uerInfoDto = new UerInfoDto();
		/*
		 * uerInfoDto.setNameId(1); uerInfoDto.setName("rabin");
		 * uerInfoDto.setCountry("nepal"); uerInfoDto.setState("bhaktapur");
		 * uerInfoDto.setPhoneNumber(12345);
		 */

		//UserInfoEntity userInfoEntity = new UserInfoEntity();
		/*
		 * userInfoEntity.setNameId(1); userInfoEntity.setName("hari");
		 * userInfoEntity.setCountry("america"); userInfoEntity.setState("california");
		 * userInfoEntity.setPhoneNumber(23456);
		 */

		when(userUpdateRepository.findById(anyLong())).thenReturn(Optional.empty());
		when(userUpdateRepository.save(userInfoEntity)).thenReturn(userInfoEntity);
		// act
		String msg = userUpdateServiceImpl.updateUserDetailByNameId(uerInfoDto,nameId);
		// assert
	    assertEquals("record is not present", msg);
	    

	}


}
