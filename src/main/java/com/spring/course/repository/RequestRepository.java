package com.spring.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.course.domain.Request;
import com.spring.course.domain.enums.RequestState;

public interface RequestRepository extends JpaRepository<Request, Long> {
	
	public List<Request> findAllByOwnerId(Long id);
	
	@Query("UPDATE Request SET state = ?2 WHERE id= ?1")
	public Request updateStatus(Long id, RequestState state);
	
}
