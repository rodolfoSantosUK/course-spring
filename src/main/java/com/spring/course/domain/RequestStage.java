package com.spring.course.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.spring.course.domain.enums.RequestState;


 
@Entity(name="RequestStage")
public class RequestStage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@Column(columnDefinition = "text")
	private String description ;
	
	@Column(name="realization_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date realizationDate;
	
	@Column(length =12, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState state;
	
	@ManyToOne
	@JoinColumn(name = "request_id")
	private Request request ;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User owner;

	public RequestStage(Long id, String description, Date realizationDate, RequestState state, Request request,
			User owner) {
		super();
		this.id = id;
		this.description = description;
		this.realizationDate = realizationDate;
		this.state = state;
		this.request = request;
		this.owner = owner;
	}

	public RequestStage() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRealizationDate() {
		return realizationDate;
	}

	public void setRealizationDate(Date realizationDate) {
		this.realizationDate = realizationDate;
	}

	public RequestState getState() {
		return state;
	}

	public void setState(RequestState state) {
		this.state = state;
	}
	@JsonProperty(access = Access.WRITE_ONLY)
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	 
}
