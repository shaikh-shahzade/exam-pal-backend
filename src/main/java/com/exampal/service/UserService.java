package com.exampal.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exampal.model.Role;
import com.exampal.model.User;
import com.exampal.model.UserRole;


public interface UserService {
	
	public User createUser(User user ,Boolean isHostAccount) throws Exception;
	
	public List<User> getAllUser();
	
	public User getUserById(Long id);
	
	public User updateUser(Long id , User user);
	
	public User deleteUser(Long id);
}
