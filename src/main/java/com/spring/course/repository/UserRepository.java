package com.spring.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.course.domain.User;
import com.spring.course.domain.enums.Role;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User getByName(String name);
	
	@Query("select u from User u where email = :email and password = :password " )
	public User login(@Param("email") String email, @Param ("password") String password);
	
	@Transactional(readOnly = false)
	@Modifying
	@Query("UPDATE User set role = :role where id = :id")
	public int updateRole(@Param(value = "id") Long id, @Param(value = "role") Role role);
}

