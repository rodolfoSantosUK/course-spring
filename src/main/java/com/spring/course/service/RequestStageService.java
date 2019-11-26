package com.spring.course.service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.course.domain.RequestStage;
import com.spring.course.domain.enums.RequestState;
import com.spring.course.repository.RequestRepository;
import com.spring.course.repository.RequestStageRepository;

@Service
public class RequestStageService {

	@Autowired
	private RequestStageRepository requestStageRepository;
	
	@Autowired
	private RequestRepository requestRepository;
	
	public RequestStage save (RequestStage stage) {
		stage.setRealizationDate(new Date());
		RequestStage createdStage = requestStageRepository.save(stage);
		
		Long requestId = stage.getRequest().getId();
		RequestState state = stage.getState();
		
		requestRepository.updateStatus(requestId, state);
		
		return createdStage ; 
	}
	
	public RequestStage update(RequestStage requestStage) {
		RequestStage updatedRequestStage = requestStageRepository.save(requestStage);
		return updatedRequestStage;
	}
	
	
	public RequestStage getById(Long id) {
		Optional<RequestStage> result = requestStageRepository.findById(id);
		return result.get();
	}
	
	public List<RequestStage> listAllByRequestId(Long requestId) {
		List<RequestStage> stages = requestStageRepository.findAllByRequestId(requestId);
		return stages ; 
	}
	
	public List<RequestStage> listAll() {
		List<RequestStage> requestStage = requestStageRepository.findAll();
		return requestStage;
	}
}
