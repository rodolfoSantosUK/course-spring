package com.spring.course.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.course.domain.Request;
import com.spring.course.domain.enums.RequestState;
import com.spring.course.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository requestRepository;

	public Request save(Request request) {

		request.setStatus(RequestState.OPEN);
		request.setCreadtionDate(new Date());
		Request createdRequest = requestRepository.save(request);
		return createdRequest;
	}
	
	public Request update(Request request) {
		Request updateRequested = requestRepository.save(request);
		return  updateRequested;
	}

	public Request getById(Long id) {
		Optional<Request> result = requestRepository.findById(id);
		return result.get();
	}
	
	public List<Request> listAll() {
		List<Request> requests = requestRepository.findAll();
		return requests;
	}
 
	public List<Request> listAllByOwnerId(Long ownerId) {
		List<Request> requests = requestRepository.findAllByOwnerId(ownerId);
		return requests;
	}
	
}
