package com.exampal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.quiz.QuizAttempt;

public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {

}
