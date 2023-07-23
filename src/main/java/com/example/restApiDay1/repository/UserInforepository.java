package com.example.restApiDay1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restApiDay1.entity.UserInfoEntity;


@Repository
public interface UserInforepository extends JpaRepository<UserInfoEntity,Long>{


	List<UserInfoEntity> findByCountry(String country);

	

	

}
