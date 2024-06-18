package com.example.appDemo.fullStackAppDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.appDemo.fullStackAppDemo.entity.feedBackEntity;

public interface feedBackRepository extends JpaRepository<feedBackEntity, Long>{
	@Query("select feedBack from feedBackEntity feedBack")
	public List<feedBackEntity> getAllReviews();
}
