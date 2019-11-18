package com.spring.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.course.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User getByName(String name);
	
	@Query("select u from User u where email = :email and password = :password " )
	public User login(@Param("email") String email, @Param ("password") String password);
	
	
	
}

