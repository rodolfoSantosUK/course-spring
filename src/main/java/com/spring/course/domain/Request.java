package com.spring.course.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.spring.course.domain.enums.RequestState;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Entity(name= "Request")
public class Request implements  Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	private Long id;
	
	@Column(columnDefinition = "text")
	private String subject;
	
	@Column(columnDefinition = "text")
	private String description;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Column(length =12, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState status ;

	@ManyToOne
	@JoinColumn(name="owner_id", nullable = false) // nome da chave estrangeira em Request
	private User owner;
	
	@OneToMany(mappedBy = "request")
	private List<RequestStage> stages =  new ArrayList<RequestStage>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreadtionDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public RequestState getStatus() {
		return status;
	}

	public void setStatus(RequestState status) {
		this.status = status;
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

	 

	public Request(Long id, String subject, String description, Date creationDate, RequestState status, User owner,
			List<RequestStage> stages) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.creationDate = creationDate;
		this.status = status;
		this.owner = owner;
		this.stages = stages;
	}

	public Request() {
		super();
	}
	
	
	
	
	
}
