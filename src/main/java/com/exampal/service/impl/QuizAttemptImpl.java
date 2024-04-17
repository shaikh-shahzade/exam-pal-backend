package com.exampal.service.impl;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
	public QuizAttempt createAttempt(Long quizId, Principal principal) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId).get();
		QuizAttempt quizAttempt = QuizAttempt
				.builder()
				.quiz(quiz)
				.status("Started")
				.startTime(LocalDateTime.now())
				.date(LocalDate.now())
				.build();
		
		
		return attemptRepository.save(quizAttempt);
	}

}
