package com.exampal.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.exampal.model.User;
import com.exampal.model.UserRole;
import com.exampal.repo.RoleRepository;
import com.exampal.repo.UserRepository;
import com.exampal.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {

		User localUser = this.userRepository.findUserByUsername(user.getUsername());
		if(localUser!=null)
			throw new Exception("User Already exists");
		
		for(UserRole userRole:userRoles)
		{
			this.roleRepository.save(userRole.getRole());
		}
		user.setUserRole(userRoles);
		user = this.userRepository.save(user);
		
		return null;
	}

}
