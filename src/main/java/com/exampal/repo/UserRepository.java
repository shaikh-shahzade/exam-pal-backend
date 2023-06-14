package com.exampal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByUsername(String username);

}
