package com.exampal.service;

import java.util.List;

import com.exampal.model.quiz.Question;

public interface QuestionService {
	
	public List<Question> getQuestionsByQuizId(Long quizId);

	public List<Question> createQuestions(List<Question> questions, Long quizId);
}
