package com.exampal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
