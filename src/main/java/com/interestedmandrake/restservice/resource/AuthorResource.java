package com.interestedmandrake.restservice.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.interestedmandrake.restservice.dto.AuthorDTO;
import com.interestedmandrake.restservice.exception.AuthorNotFoundException;
import com.interestedmandrake.restservice.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorResource {
	
	@Autowired 
	private AuthorService authorService;
	
	@GetMapping
	public ResponseEntity<List<AuthorDTO>> getAllAuthors(){
		return new ResponseEntity<List<AuthorDTO>>(authorService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AuthorDTO> retrieveAuthor(@PathVariable int id) {
		AuthorDTO author = authorService.findAuthor(id);
		if(author == null) {
			throw new AuthorNotFoundException("Author " + id + " not found.");
		}
				
		return new ResponseEntity<AuthorDTO>(author, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<AuthorDTO> createAuthor(@Valid @RequestBody AuthorDTO author){
		AuthorDTO savedAuthor = authorService.save(author);
				
		URI location = ServletUriComponentsBuilder 
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedAuthor.getId()).toUri();
				
		return ResponseEntity.created(location).build();
	}
	
}
