package com.example.restApiDay1.serviceImpl;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.restApiDay1.dto.LoginDto;
import com.example.restApiDay1.dto.Message;
import com.example.restApiDay1.entity.LoginEntity;
import com.example.restApiDay1.repository.LoginRepository;
import com.example.restApiDay1.response.ClientResposeDto;
import com.example.restApiDay1.service.LoginService;
import com.example.restApiDay1.validation.UsernameAndPasswordValidate;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginRepository loginRepository;

	@Autowired
	UsernameAndPasswordValidate emailAndPasswordValidate;

	// to check user exist or not
	// it is created because it helps to decrease biolerplate code.we can use it
	// again and again
	@Lazy(true)
	public boolean checkUserExst(String email) {
		// Optional<LoginEntity>checkuser=loginRepository.findByemail(email);
		// loginRepository.existsByemail(email);
		if (loginRepository.existsByEmail(email)) {
			return true;
		}
		return false;
	}

	@Override
	@Lazy(true)
	public Message userLoginRegister(LoginDto loginDto) {
		Message message = new Message();
		LocalTime starttime = LocalTime.now();

		LoginEntity loginEntity = new LoginEntity();// blank
		BeanUtils.copyProperties(loginDto, loginEntity);
		boolean userExistOrNot = checkUserExst(loginEntity.getEmail());// calling metod

		if (emailAndPasswordValidate.usernameValidate(loginDto)) {
			LocalTime endtime = LocalTime.now();
			Long finaltime = (long) (endtime.getNano() - starttime.getNano());
			LocalDate date = LocalDate.now();

			message.setMessage("email or password not valid");
			message.setTime(finaltime);
			// message.setDate(date);
			return message;
		}

		if (userExistOrNot) {
			LocalTime endtime = LocalTime.now();
			Long finaltime = (long) (endtime.getNano() - starttime.getNano());
			message.setMessage("user already exist");
			message.setTime(finaltime);
			LocalDate date = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");// for american date pattern
			String americanDate = date.format(formatter);
			message.setDate(americanDate);
			return message;
		} else {
			loginEntity.setRoll("user");// giving role to the record
			loginRepository.save(loginEntity);
			LocalTime endtime = LocalTime.now();
			Long finaltime = (long) (endtime.getNano() - starttime.getNano());
			message.setMessage("save user");
			message.setTime(finaltime);
			LocalDate date = LocalDate.now();
			// message.setDate(date); //for joda time(year/month/day) use LocalDate date; as
			// attribute in Message class
			return message;
		}
	}

	@Override
	public String deleteById(LoginDto loginDto) {
		LoginEntity loginEntity = new LoginEntity();// blank
		BeanUtils.copyProperties(loginDto, loginEntity);
		boolean userExistOrNot = checkUserExst(loginEntity.getEmail());
		if (userExistOrNot) {
			loginRepository.deleteByEmail(loginEntity.getEmail());
			return "delete Successfully";
		} else {
			return "delete failed user not exist";
		}

	}

	@Override
	public String fingByEmail(int id, String email) {
		Optional<LoginEntity> optional = loginRepository.findById(id);
		if (optional.get().getEmail() == email) {
			return "duplicate value";
		}
		LoginEntity loginEntity = optional.get();
		loginEntity.setEmail(email);
		LoginDto loginDto = new LoginDto();
		BeanUtils.copyProperties(loginEntity, loginDto);
		loginRepository.save(loginEntity);
		return "saved";
	}

	
	  @Override
	  public List<LoginDto> getAllRecord(int page,int limit) { 
		 // List<LoginEntity>loginEntity = loginRepository.findAll(); 
		 // return loginEntity.stream().map(ld  -> { 
			 // // return loginRepository.findAll().stream().map(ld->{//map method returns 
			//  // stream--ld is LoginDto 
			//  LoginDto allUserInfo = new LoginDto();//blank
			//  BeanUtils.copyProperties(ld, allUserInfo); 
			//  return allUserInfo;
	//  }).collect(Collectors.toList());
	 // }

	
	List<LoginDto> loginDtoList = new ArrayList<>();// blank list
	
	if(page>0)page=page-1;
	Pageable pageableRequest= PageRequest.of(page, limit);
	
	Page<LoginEntity> pageEntity = loginRepository.findAll(pageableRequest);
	List<LoginEntity>loginEntity=pageEntity.getContent();
	for (LoginEntity gettingrecord : loginEntity) {
		LoginDto allUserInfo = new LoginDto();// blank
		BeanUtils.copyProperties(gettingrecord, allUserInfo);
		loginDtoList.add(allUserInfo);
	}
	return loginDtoList;

}

	@Override
	public List<ClientResposeDto> getAllRecordByUserRoll(String roll) {
		List<LoginEntity> loginEntity = loginRepository.findByRoll(roll);
		List<ClientResposeDto> loginDtoList = new ArrayList<>();// blank list

		for (LoginEntity gettingrecord : loginEntity) {
			ClientResposeDto allUserInfo = new ClientResposeDto();// blank
			BeanUtils.copyProperties(gettingrecord, allUserInfo);// copying
			loginDtoList.add(allUserInfo);
		}
		return loginDtoList;
	}

	@Override
	public List<LoginDto> getAllRecords() {

		List<LoginDto> loginDtoList = new ArrayList<>();// blank list
		

		
		List<LoginEntity> pageEntity = loginRepository.findAll();
		
		for (LoginEntity gettingrecord : pageEntity) {
			LoginDto allUserInfo = new LoginDto();// blank
			BeanUtils.copyProperties(gettingrecord, allUserInfo);
			loginDtoList.add(allUserInfo);
		}
		return loginDtoList;

	}
	

}
