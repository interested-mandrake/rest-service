package com.interestedmandrake.restservice.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * a controller class to display the metrics counted in our interceptor
 *
 */
@RestController
@RequestMapping("/metrics")
public class MetricsResource {
	
	static Integer numRequests = 0;
	
	@GetMapping("/numRequests")
	public ResponseEntity<String> getNumHits()
	{
		return new ResponseEntity<String>("Number of requests: " + String.valueOf(numRequests), HttpStatus.OK);
	}
	
}
