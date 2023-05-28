package com.exampal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampal.model.Quiz;
import com.exampal.repo.QuizRepository;
import com.exampal.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepo;
	
	@Override
	public Quiz createQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Quiz> getAllQuiz() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Quiz getQuizById(Integer qid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Quiz updateQuiz(Integer qid, Quiz quiz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Quiz deleteQuiz(Integer qid) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
