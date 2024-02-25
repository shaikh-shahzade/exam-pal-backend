package com.exampal.service;

import java.util.List;
import java.util.Set;

import com.exampal.model.Quiz;

public interface QuizService {

	public Quiz createQuiz(Quiz quiz, String username);
	
	public List<Quiz> getAllQuiz(Integer page, Integer count, String sortBy, String sorting);
	
	public Quiz getQuizById(Long qid);
	
	public Quiz updateQuiz(Long qid , Quiz quiz);
	
	public Quiz deleteQuiz(Long qid);
}
