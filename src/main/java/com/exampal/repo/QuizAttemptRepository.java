package com.exampal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.quiz.Quiz;
import com.exampal.model.quiz.QuizAttempt;

public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {

	public List<QuizAttempt> findByQuiz(Quiz quiz);
}
