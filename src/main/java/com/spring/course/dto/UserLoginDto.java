package com.spring.course.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserLoginDto {

	@Email(message = "Invalid email address")
	private String email;
	
	@NotBlank(message = "Password required")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserLoginDto(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public UserLoginDto() {

	}
	 
	
}
