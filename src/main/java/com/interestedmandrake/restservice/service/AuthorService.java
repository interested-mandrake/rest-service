package com.interestedmandrake.restservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.interestedmandrake.restservice.dto.AuthorDTO;

@Service
public class AuthorService {
	private static List<AuthorDTO> authors = new ArrayList<>();
	
	private static int authorCount = 3;
	
	static {
		authors.add(new AuthorDTO(1, "Maya Angelou", new Date()));
		authors.add(new AuthorDTO(2, "J. K. Rowling", new Date()));
		authors.add(new AuthorDTO(3, "J. R. R. Tolkien", new Date())); 
	}
	
	public List<AuthorDTO> findAll(){
		return authors;
	}
	
	public AuthorDTO save(AuthorDTO author) {
		if(author.getId() == null) {
			author.setId(++authorCount);
		}
		authors.add(author);
		return author;
	}
	
	public AuthorDTO findAuthor(int id) {
		for(AuthorDTO author : authors) {
			if(author.getId() == id) {
				return author;
			}
		}
		return null;
	}
	
}
