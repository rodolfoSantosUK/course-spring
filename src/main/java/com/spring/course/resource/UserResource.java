package com.spring.course.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.course.domain.User;
import com.spring.course.dto.UserLoginDto;
import com.spring.course.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserResource {

	@Autowired
	private UserService userService;

	public ResponseEntity<User> save(@RequestBody User user, UriComponentsBuilder uriBuilder) {
		User createdUser = userService.save(user);
		URI uri = uriBuilder.path("/users/{id}").buildAndExpand(createdUser.getId()).toUri();
		return ResponseEntity.created(uri).body(createdUser);
	}

	public ResponseEntity<User> update(@PathVariable(name="id") Long id, @RequestBody User user  ) {
		user.setId(id);
		User updatedUser = userService.update(user);
		return ResponseEntity.ok(user);
		
	}

	public ResponseEntity<User> login (@RequestBody UserLoginDto user) {
		User loggedUser = userService.login(user.getEmail(), user.getPassword());
		return ResponseEntity.ok(loggedUser);
	}
	
}
