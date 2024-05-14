package com.exampal.service;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exampal.model.Role;
import com.exampal.model.User;
import com.exampal.model.UserRole;


public interface UserService {
	
	public User createUser(User user ,Boolean isHostAccount) throws Exception;
	
	public List<User> getAllUser( Principal principal);
	
	public User getUserById(Long id , Principal principal);
	
	public User updateUser(Long id , User user , Principal principal);
	
	public User deleteUser(Long id , Principal principal);
}
