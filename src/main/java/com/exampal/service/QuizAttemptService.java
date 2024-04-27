package com.exampal.service;

import java.security.Principal;

import com.exampal.model.quiz.QuizAttempt;
import com.exampal.model.quiz.Result;

public interface QuizAttemptService {

	public QuizAttempt createAttempt(Long quizId, Principal principal);

	public QuizAttempt submitQuizAndEvaluate(QuizAttempt quizAttempt, Principal principal);

	public Result getResultById(Long id);
}
