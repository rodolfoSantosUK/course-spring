package com.spring.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.course.domain.RequestStage;

public interface RequestStageRepository extends JpaRepository<RequestStage, Long>  {

	public List<RequestStage> findAllByRequestId(Long id);
	
	
}
