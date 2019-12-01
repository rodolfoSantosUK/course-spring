package com.spring.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.course.domain.User;
import com.spring.course.exception.NotFoundException;
import com.spring.course.model.PageModel;
import com.spring.course.model.PageRequestModel;
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

	public PageModel<User> listAllOnLazyModel(PageRequestModel pr) {
		Pageable pageable = PageRequest.of(pr.getPage(), pr.getSize());
		Page<User>  page = userRepository.findAll(pageable);
		
		PageModel<User> pm = new PageModel<>((int)page.getTotalElements(), page.getSize(), 
				                             page.getTotalPages(), page.getContent());
		
        return pm;
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
