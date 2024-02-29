package com.exampal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.quiz.Question;
import com.exampal.model.quiz.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	public List<Question> findByQuiz(Quiz quiz);
}
