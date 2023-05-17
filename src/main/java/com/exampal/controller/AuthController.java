package com.exampal.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampal.config.JwtUtil;
import com.exampal.model.JwtRequest;
import com.exampal.model.JwtLoginResponse;

@RestController
@RequestMapping("auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping("/generate")
	public ResponseEntity<JwtLoginResponse> getToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		// assuming request dont have token
		System.out.println("username");
		String username = jwtRequest.getUsername();
		String password = jwtRequest.getPassword();
		this.authenticate(username, password);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

		final String token = jwtUtil.generateToken(userDetails);
		return new ResponseEntity<JwtLoginResponse>(new JwtLoginResponse(token,userDetails), HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
