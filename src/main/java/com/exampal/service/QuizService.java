package com.exampal.service;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.exampal.model.quiz.Quiz;

public interface QuizService {

	public Quiz createQuiz(Quiz quiz, String username);
	
	public List<Quiz> getAllQuiz(Integer page, Integer count, String sortBy, String sorting, String searchKey, Boolean host, Principal principal);
	
	public Quiz getQuizById(Long qid);
	
	public Quiz updateQuiz(Long qid , Quiz quiz);
	
	public Quiz deleteQuiz(Long qid);
}
