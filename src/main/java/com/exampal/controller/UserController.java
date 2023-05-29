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
import org.springframework.web.bind.annotation.RestController;

import com.exampal.model.Role;
import com.exampal.model.User;
import com.exampal.model.UserRole;
import com.exampal.service.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("{id}")
	public User getUserById(@PathVariable(name = "id") Integer id) {
		return this.userService.getUserById(id);
	}

	@GetMapping("")
	public List<User> getAlluser() {

		return this.userService.getAllUser();
	}

	@PostMapping("")
	public User createUser(@RequestBody User user) throws Exception {
		Set<UserRole> userRoles = new HashSet<UserRole>();
		UserRole userRole = new UserRole();

		Role role = new Role();
		role.setId(11L);
		role.setRole("normal-user");
		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);

		return this.userService.createUser(user, userRoles);
	}
}
