package com.exampal.service;

import java.security.Principal;
import java.util.List;

import com.exampal.model.quiz.QuizAttempt;
import com.exampal.model.quiz.Result;

public interface QuizAttemptService {

	public QuizAttempt createAttempt(Long quizId, Principal principal);

	public QuizAttempt submitQuizAndEvaluate(QuizAttempt quizAttempt, Principal principal);

	public QuizAttempt getResultById(Long id);

	public List<QuizAttempt> getResultsByQuiz(Long id);

	public List<QuizAttempt> getResultsByHost(Principal principal);
}
