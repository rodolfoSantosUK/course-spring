package com.spring.course.dto;

import com.spring.course.domain.enums.Role;

public class UserUpdateRoleDto {
  private Role role;

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

public UserUpdateRoleDto(Role role) {
	super();
	this.role = role;
}

public UserUpdateRoleDto() {
	super();
}
  
  
  
}
