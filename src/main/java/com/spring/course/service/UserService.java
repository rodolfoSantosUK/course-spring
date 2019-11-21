package com.spring.course.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.course.domain.User;
import com.spring.course.repository.UserRepository;
import com.spring.course.service.util.HashUtil;

public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		
		User createdUser = userRepository.save(user);
		return createdUser;
	}

	public User update(User user) {
		
		String hash = HashUtil.getSecureHash(user.getPassword());
		user.setPassword(hash);
		
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

	public User getById(Long id) {
		Optional<User> result = userRepository.findById(id);
		return result.get();
	}

	public User login(String email, String password) {
		
		password = HashUtil.getSecureHash(password);
		
		User user = userRepository.login(email, password);
		return user;
	}
}
