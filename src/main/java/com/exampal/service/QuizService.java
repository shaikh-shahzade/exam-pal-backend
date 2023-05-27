package com.exampal.service;

import java.util.List;
import java.util.Set;

import com.exampal.model.Quiz;

public interface QuizService {

	public Quiz createQuiz(Quiz quiz);
	
	public List<Quiz> getAllQuiz();
	
	public Quiz getQuizById(Integer qid);
	
	public Quiz updateQuiz(Integer qid , Quiz quiz);
	
	public Quiz deleteQuiz(Integer qid);
}
