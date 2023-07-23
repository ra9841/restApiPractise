package com.example.restApiDay1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restApiDay1.entity.LoginEntity;
@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

	void deleteByEmail( String string);

	Optional<LoginEntity> findByEmail(String username);

	boolean existsByEmail(String username);

	List<LoginEntity> findByRoll(String roll);

	

	

	

}
