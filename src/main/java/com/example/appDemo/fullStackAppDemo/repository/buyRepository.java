package com.example.appDemo.fullStackAppDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.appDemo.fullStackAppDemo.entity.BuyEntity;

public interface buyRepository  extends JpaRepository<BuyEntity, Long>{
	public List<BuyEntity> findByEmailID(String emailID);
	public BuyEntity findByImageID(long imageID);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update BuyEntity buyrepo set buyrepo.count=:count where buyrepo.emailID =:emailId AND buyrepo.imageID=:imageid")
	public void updateBuyRepository (@Param("count") int count,
			@Param("emailId") String emailId,@Param("imageid") long imageid);
	
}
