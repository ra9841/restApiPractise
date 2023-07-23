package com.example.restApiDay1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restApiDay1.entity.ClientUserInfoEntity;

@Repository
public interface ClientUserInfoRepository extends JpaRepository<ClientUserInfoEntity,Long> {

	List<ClientUserInfoEntity> findByCountryAndRoll(String country, String roll);

}
