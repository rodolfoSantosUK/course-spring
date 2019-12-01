package com.spring.course.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.spring.course.domain.Request;
import com.spring.course.domain.RequestStage;
import com.spring.course.domain.User;
import com.spring.course.domain.enums.RequestState;

public class RequestUpdateDto {

	@NotBlank 
	private String subject;

	private String description;
	
	@NotNull
	private RequestState state;

	@NotNull
	private User owner;

	private List<RequestStage> stages = new ArrayList<RequestStage>();
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RequestState getState() {
		return state;
	}

	public void setState(RequestState state) {
		this.state = state;
	}

	public RequestUpdateDto(@NotBlank String subject, String description, @NotNull RequestState state) {
		super();
		this.subject = subject;
		this.description = description;
		this.state = state;
	}

	public RequestUpdateDto() {
		super();
	}
	
	public Request transformRequest() {
		Request request = new Request(null, subject, description, null, this.state, this.owner, stages);
		return request;
	}
	
	
}
