package com.example.restApiDay1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restApiDay1.dto.UerInfoDto;
import com.example.restApiDay1.entity.UserInfoEntity;
@Repository
public interface UserUpdateRepository extends JpaRepository<UserInfoEntity,Long> {

	

}
