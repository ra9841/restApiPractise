package com.example.restApiDay1.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.NotThrownAssert;
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
import com.example.restApiDay1.repository.UserInforepository;

//@RunWith(MockitoJUnitRunner.class)//for junit 4
@ExtendWith(MockitoExtension.class)//for junit 5
@MockitoSettings(strictness=Strictness.LENIENT)
class UserInfoServiceImplTest {
	@InjectMocks
	UserInfoServiceImpl userInfoServiceImpl;

	@Mock
	UserInforepository userInforepository;
	
	@Mock
	LoginServiceImpl loginserviceimpl;

	private UerInfoDto uerInfoDto;
	
	  @BeforeEach 
	  void init() {
		  uerInfoDto=new UerInfoDto();
		  uerInfoDto.setName("roshandsfhdkghkjfhks");
		  uerInfoDto.setCountry("nepal");
		  uerInfoDto.setState("bhaktapur");
		  uerInfoDto.setPhoneNumber(1233455);
	  }
	 

	@Test
	public void testUserRegisterInfo() {
		// arrange
		UerInfoDto uerInfoDto = new UerInfoDto();
		/*
		 * uerInfoDto.setName("roshandsfhdkghkjfhks"); uerInfoDto.setCountry("nepal");
		 * uerInfoDto.setState("bhaktapur"); uerInfoDto.setPhoneNumber(1233455);
		 */
		
		when(loginserviceimpl.checkUserExst(any())).thenReturn(false);
		when(userInforepository.save(any(UserInfoEntity.class))).thenReturn(new UserInfoEntity());

		// Act
		String result = userInfoServiceImpl.userLoginRegisterInfo(uerInfoDto);

		// Assert
		assertEquals("usersave", result);
		
	}
	

	@Test
	public void testUserRegisterAlreadyExist() {
		// arrange
		UerInfoDto uerInfoDto = new UerInfoDto();
		uerInfoDto.setName("roshandsfhdkghkjfhks");
		uerInfoDto.setCountry("nepal");
		uerInfoDto.setState("bhaktapur");
		uerInfoDto.setPhoneNumber(1233455);
		
		when(loginserviceimpl.checkUserExst(any())).thenReturn(true);
		when(userInforepository.save(any(UserInfoEntity.class))).thenReturn(new UserInfoEntity());

		// Act
		String result = userInfoServiceImpl.userLoginRegisterInfo(uerInfoDto);

		// Assert
		assertEquals("already exist", result);
	}
	
	
	@Test
	public void testgetAllRecordByCountry() {
		//arrange
		String country="america";
		List<UerInfoDto> uerInfoDtoList = new ArrayList<>();
		//we are doing from entity so not using dto
		/*
		 * UerInfoDto uerInfoDto = new UerInfoDto();
		 * uerInfoDto.setName("roshandsfhdkghkjfhks"); uerInfoDto.setCountry("america");
		 * uerInfoDto.setState("bhaktapur"); uerInfoDto.setPhoneNumber(1233455);
		 * 
		 * UerInfoDto uerInfoDto2 = new UerInfoDto(); uerInfoDto2.setName("roshand");
		 * uerInfoDto2.setCountry("america"); uerInfoDto2.setState("bhaktapur");
		 * uerInfoDto2.setPhoneNumber(1233455);
		 * 
		 * uerInfoDtoList.add(uerInfoDto); uerInfoDtoList.add(uerInfoDto2);
		 */
		
		List<UserInfoEntity> userInfoEntityList = new ArrayList<>();
		UserInfoEntity userInfoEntity = new UserInfoEntity();
		userInfoEntity.setName("roshandsfhdkghkjfhks");
		userInfoEntity.setCountry("america");
		userInfoEntity.setState("bhaktapur");
		userInfoEntity.setPhoneNumber(1233455);
		
		UserInfoEntity userInfoEntity2 = new UserInfoEntity();
		userInfoEntity2.setName("roshand");
		userInfoEntity2.setCountry("america");
		userInfoEntity2.setState("bhaktapur");
		userInfoEntity2.setPhoneNumber(1233455);
		
		userInfoEntityList.add(userInfoEntity);
		userInfoEntityList.add(userInfoEntity2);
		
		when(userInforepository.findByCountry(country)).thenReturn(userInfoEntityList);
		
		//act
		List<UerInfoDto> UerInfo  = userInfoServiceImpl.getAllRecordByCountry(country); 
		
		//assert
		//assertEquals(uerInfoDtoList.get(0).getCountry(),msg.get(0).getCountry());
		assertEquals("roshandsfhdkghkjfhks",UerInfo.get(0).getName());
		assertEquals("america",UerInfo.get(0).getCountry());
		assertEquals("roshand",UerInfo.get(1).getName());
		assertEquals("america",UerInfo.get(1).getCountry());
	
	}
	
}
