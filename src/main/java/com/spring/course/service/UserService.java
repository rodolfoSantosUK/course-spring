package com.spring.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.course.domain.User;
import com.spring.course.exception.NotFoundException;
import com.spring.course.repository.UserRepository;
import com.spring.course.service.util.HashUtil;

@Service
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
		user.setPassword(getById(user.getId()).getPassword());
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

	public User getById(Long id) {
		Optional<User> result = userRepository.findById(id);
		return result.orElseThrow(()-> new NotFoundException("There are not User with id = " + id));
	}

	public User login(String email, String password) {
		password = HashUtil.getSecureHash(password);
		User user = userRepository.login(email, password);
		return user;
	}
	
	public List<User> listAll() {
		List<User> 	users = userRepository.findAll();
		return users;
	}
	
}
