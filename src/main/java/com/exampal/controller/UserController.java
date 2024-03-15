package com.exampal.controller;

import java.util.Set;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exampal.model.Role;
import com.exampal.model.User;
import com.exampal.model.UserRole;
import com.exampal.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin(origins ="*")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("{id}")
	public User getUserById(@PathVariable(name = "id") Long id) {
		return this.userService.getUserById(id);
	}

	@GetMapping("")
	public List<User> getAlluser() {

		return this.userService.getAllUser();
	}

	@PostMapping("")
	public User createUser(
			@RequestBody User user,  
			@RequestParam(required = true) boolean isHostAccount) throws Exception 
	{
		return this.userService.createUser(user, isHostAccount);
	}
}
