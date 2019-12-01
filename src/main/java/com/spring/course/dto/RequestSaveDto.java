package com.spring.course.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.spring.course.domain.Request;
import com.spring.course.domain.RequestStage;
import com.spring.course.domain.User;

public class RequestSaveDto {

	@NotNull
	private String subject;

	private String description;

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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<RequestStage> getStages() {
		return stages;
	}

	public void setStages(List<RequestStage> stages) {
		this.stages = stages;
	}

	public RequestSaveDto(String subject, String description, User owner, List<RequestStage> stages) {
		super();
		this.subject = subject;
		this.description = description;
		this.owner = owner;
		this.stages = stages;
	}

	public RequestSaveDto() {
		super();
	}

	public Request transformRequest() {
		Request request = new Request(null, subject, description, null, null, this.owner, stages);
		return request;
	}

}
