package com.exampal.service.impl;

import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exampal.exception.ResourceNotFoundException;
import com.exampal.exception.UnuthorizedAccessException;
import com.exampal.model.Role;
import com.exampal.model.User;
import com.exampal.model.UserRole;
import com.exampal.repo.RoleRepository;
import com.exampal.repo.UserRepository;
import com.exampal.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User createUser(User user,Boolean isHostAccount) throws Exception {

		User localUser = this.userRepository.findUserByUsername(user.getUsername());
		if(localUser!=null)
			throw new Exception("User Already exists");
		
		UserRole userRole = new UserRole();
		Role role;
		if(isHostAccount)
		{
			role = new Role();
			role.setId(22L);
			role.setRole("admin");
		}
		else
		{
			role = new Role();
			role.setId(11L);
			role.setRole("normal-user");
		}
		
		role =this.roleRepository.save(role);
		userRole.setUser(user);
		userRole.setRole(role);
		user.setUserRole(Set.of(userRole));
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		user = this.userRepository.save(user);
		return user;
	}

	@Override
	public List<User> getAllUser(Principal principal) {
		checkAccess(0l,principal);
		return userRepository.findAll();
	
	}

	@Override
	public User getUserById(Long id , Principal principal) {
		checkAccess(id,principal);
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "User ID", id));
		return user;
	}

	@Override
	public User updateUser(Long id, User user , Principal principal) {
		
		checkAccess(id, principal);
		
		User userResult = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "User ID", id));
		user.setId(userResult.getId());
		userRepository.save(user);
		return user;
	}

	private void checkAccess(Long id, Principal principal) {
		User principal_user = this.userRepository.findUserByUsername(principal.getName());
		
		boolean isHost = principal_user.getUserRole().stream().anyMatch(ur->ur.getRole().getRole()=="admin");
		System.out.println( principal_user.getId().equals(id));
		if(isHost||!principal_user.getId().equals(id))
			throw new UnuthorizedAccessException("User", "userId", id);
	}

	@Override
	public User deleteUser(Long id , Principal principal) {
		checkAccess(id, principal);
		User userResult = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "User ID", id));
		userRepository.delete(userResult);
		return userResult;
	}

}
