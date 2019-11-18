package com.spring.course.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.spring.course.domain.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor // contrutor com todos os parametros
@NoArgsConstructor // contrutor vazio
@Getter
@Setter
@ToString // método toString
@Entity(name = "User")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column(length = 75, nullable = false, unique = true)
	private String email;
	
	@Column(length = 75, nullable = false)
	private String password;
	
	@Column(length = 20, nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "owner")
	private List<Request> requests = new ArrayList<Request>();

	@OneToMany(mappedBy = "owner")
	private List<RequestStage> stages = new ArrayList<RequestStage>();
 
}
