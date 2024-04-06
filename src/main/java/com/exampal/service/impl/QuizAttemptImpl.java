package com.exampal.service.impl;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampal.model.quiz.Quiz;
import com.exampal.model.quiz.QuizAttempt;
import com.exampal.repo.QuizAttemptRepository;
import com.exampal.repo.QuizRepository;
import com.exampal.service.QuizAttemptService;

@Service
public class QuizAttemptImpl implements QuizAttemptService{

	@Autowired
	private QuizAttemptRepository attemptRepository;
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public QuizAttempt createAttempt(QuizAttempt quizAttempt, Long quizId, Principal principal) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId).get();
		quizAttempt.setQuiz(quiz);
		return attemptRepository.save(quizAttempt);
	}

}
