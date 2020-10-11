package com.interestedmandrake.restservice.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.interestedmandrake.restservice.dto.AuthorDTO;
import com.interestedmandrake.restservice.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorResource {
	
	@Autowired 
	private AuthorService authorService;
	
	@GetMapping
	public List<AuthorDTO> getAllAuthors(){
		return authorService.findAll();
	}
	
	@GetMapping("/{id}")
	public AuthorDTO retrieveAuthor(@PathVariable int id) {
		return authorService.findAuthor(id);
	}
	
	@PostMapping
	public ResponseEntity<Object> createAuthor(@Valid @RequestBody AuthorDTO author){
		AuthorDTO savedAuthor = authorService.save(author);
				
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedAuthor.getId()).toUri();
				
		return ResponseEntity.created(location).build();
	}
	
}