package com.favourite.music.user.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="Users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UsersModel {
	
	@Id
	@ApiModelProperty(notes="Users Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ApiModelProperty(notes="Adds name of user to database")
	@NotBlank
	private String name;
	
	@ApiModelProperty(notes="Adds email of user to database")
	@NotBlank
	private String email;
	
	@ApiModelProperty(notes="Adds contact number of user to database")
	@NotBlank
	private String number;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
