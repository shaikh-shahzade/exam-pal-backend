package com.exampal.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.User;
import com.exampal.model.quiz.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	public Page<Quiz> findAll(Pageable pageable);
	public Page<Quiz> findByTitleIgnoreCaseContaining(String title,Pageable pageable );
	public Page<Quiz> findAllByUser(Pageable pageable,User user);
	public Page<Quiz> findByTitleIgnoreCaseContainingAndUser(String title,Pageable pageable,User user );


}
