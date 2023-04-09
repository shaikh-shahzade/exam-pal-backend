package com.exampal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserByUsername(String username);

}
