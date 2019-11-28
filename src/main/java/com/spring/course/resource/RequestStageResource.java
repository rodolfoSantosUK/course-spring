package com.spring.course.resource;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.course.domain.RequestStage;
import com.spring.course.service.RequestStageService;

@RestController
@RequestMapping(value = "/requests-stages")
public class RequestStageResource {

	@Autowired
	private RequestStageService stageService;
	
	public ResponseEntity<RequestStage> save(@RequestBody RequestStage requestStage, UriComponentsBuilder uriBuilder) {
		RequestStage createdRequestStage = stageService.save(requestStage);
		URI uri = uriBuilder.path("/requests-stages/{id}").buildAndExpand(createdRequestStage.getId()).toUri();
		return ResponseEntity.created(uri).body(createdRequestStage);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<RequestStage> update(@PathVariable(name="id") Long id, @RequestBody RequestStage requestStage  ) {
		RequestStage updatedRequestStage = stageService.update(requestStage);
		return ResponseEntity.ok(updatedRequestStage);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RequestStage> getById(@PathVariable(name="id") Long id) {
		RequestStage requestStage = stageService.getById(id);
		return ResponseEntity.ok(requestStage);
	}
	
	@GetMapping
	public ResponseEntity<List<RequestStage>> listAll() {
		List<RequestStage> requestStage = stageService.listAll();
		return ResponseEntity.ok(requestStage);
	}
	
	@GetMapping("/{id}/requests-stages")
	public ResponseEntity<List<RequestStage>> listAllStagesById(@PathVariable(name="id") Long id) {
		List<RequestStage> stages =  stageService.listAllByRequestId(id);
		return ResponseEntity.ok(stages);
	}
	
}
