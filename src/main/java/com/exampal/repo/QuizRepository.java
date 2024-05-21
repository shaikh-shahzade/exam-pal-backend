package com.exampal.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.User;
import com.exampal.model.quiz.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	public Page<Quiz> findAll(Pageable pageable);
	public Page<Quiz> findByTitleIgnoreCaseContaining(String title,Pageable pageable );
	public Page<Quiz> findAllByHost(Pageable pageable,User host);
	public Page<Quiz> findByTitleIgnoreCaseContainingAndHost(String title,Pageable pageable,User host );


}
