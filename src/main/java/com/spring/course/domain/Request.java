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

@AllArgsConstructor // contrutor com todos os parametros
@NoArgsConstructor // contrutor vazio
@Getter
@Setter
@ToString // método toString

@Entity(name= "Request")
public class Request implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "text")
	private String subject;
	
	@Column(columnDefinition = "text")
	private String description;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creadtionDate;
	
	@Column(length =12, nullable = false)
	@Enumerated(EnumType.STRING)
	private RequestState status ;

	@ManyToOne
	@JoinColumn(name="owner_id", nullable = false) // nome da chave estrangeira em Request
	private User owner;
	
	@OneToMany(mappedBy = "request")
	private List<RequestStage> stages =  new ArrayList<RequestStage>();
	
}
