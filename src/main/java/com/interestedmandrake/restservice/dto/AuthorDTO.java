package com.interestedmandrake.restservice.dto;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="describes data related to the author") 
public class AuthorDTO {
	
	@JsonIgnore
	Integer id;
	
	@Size(min = 2)
	@ApiModelProperty(notes="name should have at least two characters")
	String name;
	
	@Past
	@ApiModelProperty(value="date of birth", notes="date of birth must be in the past")
	Date dob; 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public AuthorDTO(Integer id, @Size(min = 2) String name, @Past Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}	
	
}
