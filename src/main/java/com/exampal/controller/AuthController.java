package com.exampal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

	@PostMapping("/generate")
	public ResponseEntity<String> getToken(@RequestHeader String token , 
			@RequestBody String username , 
			@RequestBody String password)
	{
		//assuming request dont have token
		
		
		
		return new ResponseEntity<String>("No token" , HttpStatus.OK);
	}
}
