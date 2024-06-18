package com.example.appDemo.fullStackAppDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.appDemo.fullStackAppDemo.entity.cartEntity;

public interface cartRepository extends JpaRepository<cartEntity, Long>{
	//JPQL
	@Query("select count(*) from cartEntity cart where cart.emailID=:emailId")
	public long findCartDetailsByEmailId(@Param("emailId")String emailId);
	
	@Query("select cart from cartEntity cart where cart.emailID=:emailId")
	public List<cartEntity> findAllCartDetailsByUserId(@Param("emailId")String emailId);
	
	@Transactional
	@Modifying
	@Query("delete from cartEntity cart where cart.imageID=:imageID")
	public void deleteFromCartByImageID(@Param("imageID")long imageID);
}
