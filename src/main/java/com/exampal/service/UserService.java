package com.exampal.service;

import java.util.Set;

import com.exampal.model.User;
import com.exampal.model.UserRole;

public interface UserService {
	
	public User createUser(User user , Set<UserRole> UserRoles) throws Exception;
}
