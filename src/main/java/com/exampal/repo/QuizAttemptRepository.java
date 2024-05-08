package com.exampal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exampal.model.quiz.Quiz;
import com.exampal.model.quiz.QuizAttempt;

public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {

	public List<QuizAttempt> findByQuiz(Quiz quiz);
	
	@Query(value = "SELECT * FROM quiz_attempt AS q_attempt "
			+ "WHERE q_attempt.quiz_qid in (SELECT qid FROM quiz WHERE user_id = :userId ) ;"
			 , nativeQuery=true)
	public List<QuizAttempt> findByHost(@Param(value = "userId") Long userId);
}