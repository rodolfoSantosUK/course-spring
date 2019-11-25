package com.spring.course.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.course.domain.Request;
import com.spring.course.service.RequestService;

@RestController
@RequestMapping(value = "requests")
public class RequestResource {

	@Autowired
	private RequestService requestService;
	
	
	public ResponseEntity<Request> save(@RequestBody Request request, UriComponentsBuilder uriBuilder) {
		Request createdRequest = requestService.save(request);
		URI uri = uriBuilder.path("/requests/{id}").buildAndExpand(createdRequest.getId()).toUri();
		return ResponseEntity.created(uri).body(createdRequest);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Request> update(@PathVariable(name="id") Long id, @RequestBody Request request  ) {
		Request updaterRequest = requestService.update(request);
		return ResponseEntity.ok(updaterRequest);
	}
	
	@GetMapping
	public ResponseEntity<Request> getById(@PathVariable(name="id") Long id) {
		Request request = requestService.getById(id);
		return ResponseEntity.ok(request);
	}
	
	public ResponseEntity<List<Request>> listAll() {
		List<Request> requests = requestService.listAll();
		return ResponseEntity.ok(requests);
	}
	 
}
