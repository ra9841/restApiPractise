package com.example.restApiDay1.service;

import com.example.restApiDay1.dto.UerInfoDto;

public interface UserUpdateService {

	String updateUserDetailByNameId(UerInfoDto uerInfoDto, long nameId);

}
