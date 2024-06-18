package com.example.appDemo.fullStackAppDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.appDemo.fullStackAppDemo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findByEmail(String email);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update UserEntity user set user.encryptedPassword=:password where user.email =:emailId")
	public void changePassword (@Param("password") String password,
			@Param("emailId") String emailId);
}
