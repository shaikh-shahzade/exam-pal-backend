package com.exampal.service.impl;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampal.exception.ResourceNotFoundException;
import com.exampal.model.quiz.AttemptedQuestion;
import com.exampal.model.quiz.Quiz;
import com.exampal.model.quiz.QuizAttempt;
import com.exampal.repo.AttemptedQuestionRepo;
import com.exampal.repo.QuizAttemptRepository;
import com.exampal.repo.QuizRepository;
import com.exampal.repo.ResultRepo;
import com.exampal.service.QuizAttemptService;

@Service
public class QuizAttemptImpl implements QuizAttemptService {

	@Autowired
	private QuizAttemptRepository attemptRepository;

	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private AttemptedQuestionRepo attemptedQuestionRepo;

	@Autowired
	private ResultRepo resultRepo;
	@Override
	public QuizAttempt createAttempt(Long quizId, Principal principal) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId).get();
		QuizAttempt quizAttempt = QuizAttempt.builder().quiz(quiz).status("Started").startTime(LocalDateTime.now())
				.date(LocalDate.now()).build();

		return attemptRepository.save(quizAttempt);
	}

	@Override
	public QuizAttempt submitQuizAndEvaluate(QuizAttempt quizAttempt, Principal principal) {
		// TODO Auto-generated method stub
		QuizAttempt quizAttempt_retrieved = this.attemptRepository.findById(quizAttempt.getId()).orElseThrow(
				() -> new ResourceNotFoundException(QuizAttempt.class.toString(), "id", quizAttempt.getId()));
		quizAttempt_retrieved.setEndTime(LocalDateTime.now());

		List<AttemptedQuestion> attemptedQuestions = quizAttempt.getResult().getAttemptedQuestion();
		
		int marks = 0;
		
		
		
		attemptedQuestions = attemptedQuestions.stream().map(attemptQ-> {
			// save and map each question
			attemptQ.setIsCorrect(attemptQ.getAnswer().getIsCorrect());
			attemptedQuestionRepo.save(attemptQ);
			return attemptQ;
		}).collect(Collectors.toList());
		
		return null;
	}

}
