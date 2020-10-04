package com.interestedmandrake.restservice.restservice.exception.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@GetMapping("/{id}")
	public void getParticularUser()
	{
		throw new UserNotFoundException("some message");
	}
}
