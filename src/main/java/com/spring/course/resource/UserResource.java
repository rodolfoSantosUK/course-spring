package com.spring.course.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.course.domain.Request;
import com.spring.course.domain.User;
import com.spring.course.dto.UserLoginDto;
import com.spring.course.model.PageModel;
import com.spring.course.model.PageRequestModel;
import com.spring.course.service.RequestService;
import com.spring.course.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RequestService requestService;

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user, UriComponentsBuilder uriBuilder) {
		User createdUser = userService.save(user);
		URI uri = uriBuilder.path("/users/{id}").buildAndExpand(createdUser.getId()).toUri();
		return ResponseEntity.created(uri).body(createdUser);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable(name="id") Long id, @RequestBody User user  ) {
		user.setId(id);
		User updatedUser = userService.update(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable(name="id") Long id) {
	 	User user = userService.getById(id);
		User usuario = new User();
		usuario.setId(1L);
		
		return ResponseEntity.ok(user);
	}

	@GetMapping
	public ResponseEntity<PageModel<User>> listAll(
			@RequestParam(value="page", defaultValue = "0") int page,
			@RequestParam(value="size", defaultValue = "10") int size) {
		
		PageRequestModel pr = new PageRequestModel(page, size);
		PageModel<User> pm  = userService.listAllOnLazyModel(pr);
		
		return ResponseEntity.ok(pm);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> login (@RequestBody UserLoginDto user) {
		User loggedUser = userService.login(user.getEmail(), user.getPassword());
		return ResponseEntity.ok(loggedUser);
	}
	 
//	@GetMapping("{id}/requests")
//	public ResponseEntity<List<Request>> listAllRequestById(@PathVariable(name="id") Long id) {
//		List<Request> requests = requestService.listAllByOwnerId(id);
//		return ResponseEntity.ok(requests); 
//	}
	
	@GetMapping("{id}/requests")
	public ResponseEntity<PageModel<Request>> listAllRequestById(@PathVariable(name="id") Long id,
			@RequestParam(value="page", defaultValue = "0") int page,
			@RequestParam(value="size", defaultValue = "10") int size) {
		PageRequestModel   pr =  new PageRequestModel(page, size);
		PageModel<Request> pm = requestService.listAllByOwnerIdOnLazyModel(id, pr);
		return ResponseEntity.ok(pm);
	}
	
}
