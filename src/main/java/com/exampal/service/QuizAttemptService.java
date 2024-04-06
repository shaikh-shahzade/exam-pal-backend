package com.exampal.service;

import java.security.Principal;

import com.exampal.model.quiz.QuizAttempt;

public interface QuizAttemptService {

	public QuizAttempt createAttempt(QuizAttempt quizAttempt, Long quizId, Principal principal);
}
