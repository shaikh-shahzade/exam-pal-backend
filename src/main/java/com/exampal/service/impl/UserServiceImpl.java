package com.exampal.service.impl;

import java.nio.file.Files;
import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exampal.exception.ResourceNotFoundException;
import com.exampal.exception.UnuthorizedAccessException;
import com.exampal.model.Role;
import com.exampal.model.User;
import com.exampal.model.UserRole;
import com.exampal.repo.RoleRepository;
import com.exampal.repo.UserRepository;
import com.exampal.service.StorageService;
import com.exampal.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private StorageService storageService;
	
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
	public User updateUser(Long id, User user , Principal principal, MultipartFile profileImage) {
		
		checkAccess(id, principal);
		
		
		User userResult = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "User ID", id));

		if(profileImage!=null && !profileImage.isEmpty())
		{
			String suff = profileImage.getOriginalFilename().substring(profileImage.getOriginalFilename().lastIndexOf("."));
			String picName = "User"+userResult.getId()+suff;
			user.setProfile_pic(picName);
			
			this.storageService.store(profileImage , picName);
		}
			
		
		
		if(user.getEmail()!=null)
			userResult.setEmail(user.getEmail());
		if(user.getFirstName()!=null)
			userResult.setFirstName(user.getFirstName());
		if(user.getLastName()!=null)
			userResult.setLastName(user.getLastName());
		if(user.getPassword()!=null)
			userResult.setPassword(this.passwordEncoder.encode(user.getPassword()));
		if(user.getPhone()!=null)
			userResult.setPhone(user.getPhone());
		if(user.getUsername()!=null)
			userResult.setUsername(user.getUsername());
		return userRepository.save(userResult);
	}

	private void checkAccess(Long id, Principal principal) {
		User principal_user = this.userRepository.findUserByUsername(principal.getName());
		
		boolean isHost = principal_user.getUserRole().stream().anyMatch(ur->ur.getRole().getRole()=="admin");
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
