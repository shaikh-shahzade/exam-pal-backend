package com.exampal.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exampal.model.User;
import com.exampal.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("user")
@CrossOrigin(origins ="*")
public class UserController {

	@Autowired
	UserService userService;
	
	@Operation(description = "Get User by user-id")
	@GetMapping("v1/{id}")
	public User getUserById(@PathVariable(name = "id") Long id, Principal principal) {
		return this.userService.getUserById(id,principal);
	}

	@GetMapping("v1")
	public List<User> getAlluser(Principal principal) {

		return this.userService.getAllUser(principal);
	}

	@PostMapping("v1")
	public User createUser(
			@RequestBody User user,  
			@RequestParam(defaultValue = "false") boolean isHostAccount) throws Exception 
	{
		return this.userService.createUser(user, isHostAccount);
	}
	
	@PatchMapping("v1/{id}")
	public User updateUser(
			@RequestBody User user,
			@PathVariable Long id,
			Principal principal)
	{
		System.out.println("called");
		return this.userService.updateUser(id,user,principal);
	}
	
	@DeleteMapping("v1/{id}")
	public User deleteUser(@PathVariable Long id, Principal principal)
	{
		return this.userService.deleteUser(id,principal);
	}
	
}
