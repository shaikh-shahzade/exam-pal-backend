package com.exampal.service;

import java.util.List;
import java.util.Set;

import com.exampal.model.quiz.Question;
import com.exampal.model.quiz.Quiz;

public interface QuestionService {
	
	public List<Question> getQuestionsByQuizId(Long quizId);

	public List<Question> createQuestions(List<Question> questions, Long quizId);

	public List<Question> updateQuestions(List<Question> questions, Long quizId);
	
	}
