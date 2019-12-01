package com.spring.course.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.course.domain.Request;
import com.spring.course.domain.RequestStage;
import com.spring.course.dto.RequestSaveDto;
import com.spring.course.dto.RequestUpdateDto;
import com.spring.course.service.RequestService;
import com.spring.course.service.RequestStageService;

@RestController
@RequestMapping(value = "/requests")
public class RequestResource {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private RequestStageService stageService;
	
	@PostMapping
	public ResponseEntity<Request> save(@RequestBody @Valid RequestSaveDto requestSaveDto, UriComponentsBuilder uriBuilder) {
		Request request = requestSaveDto.transformRequest();
		Request createdRequest = requestService.save(request);
		URI uri = uriBuilder.path("/requests/{id}").buildAndExpand(createdRequest.getId()).toUri();
		return ResponseEntity.created(uri).body(createdRequest);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Request> update(@PathVariable(name="id") Long id, 
			                              @Valid @RequestBody RequestUpdateDto requestUpdateDto  ) {
		Request request = requestUpdateDto.transformRequest();
		Request updaterRequest = requestService.update(request);
		return ResponseEntity.ok(updaterRequest);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Request> getById(@PathVariable(name="id") Long id) {
		Request request = requestService.getById(id);
		return ResponseEntity.ok(request);
	}
	
	@GetMapping
	public ResponseEntity<List<Request>> listAll() {
		List<Request> requests = requestService.listAll();
		return ResponseEntity.ok(requests);
	}
	 
	@GetMapping("/{id}/requests-stages")
	public ResponseEntity<List<RequestStage>> listAllStagesById(@PathVariable(name="id") Long id) {
		List<RequestStage> stages =  stageService.listAllByRequestId(id);
		return ResponseEntity.ok(stages);
	}
	
}
