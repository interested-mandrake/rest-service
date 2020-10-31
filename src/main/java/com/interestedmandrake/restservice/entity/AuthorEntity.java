package com.interestedmandrake.restservice.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AuthorEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private Date dob;
	
	protected AuthorEntity() {}

	public AuthorEntity(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	
	
}
