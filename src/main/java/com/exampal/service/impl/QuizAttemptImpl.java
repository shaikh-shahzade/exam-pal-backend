package com.exampal.service.impl;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampal.model.quiz.QuizAttempt;
import com.exampal.repo.QuizAttemptRepository;
import com.exampal.service.QuizAttemptService;

@Service
public class QuizAttemptImpl implements QuizAttemptService{

	@Autowired
	private QuizAttemptRepository attemptRepository;
	@Override
	public QuizAttempt createAttempt(QuizAttempt quizAttempt, Principal principal) {
		// TODO Auto-generated method stub
		
		return attemptRepository.save(quizAttempt);
	}

}
