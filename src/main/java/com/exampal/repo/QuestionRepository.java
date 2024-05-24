package com.exampal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exampal.model.quiz.Question;
import com.exampal.model.quiz.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	@Query(value ="SELECT * FROM question "
			+ "where quiz_qid=:quiz ;" , nativeQuery=true)
	public List<Question> findByQuiz(@Param(value="quiz") Long quizId);
}
