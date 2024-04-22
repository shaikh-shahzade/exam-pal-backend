package com.exampal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampal.model.quiz.QuizAttempt;
import com.exampal.model.quiz.Result;
import com.exampal.repo.ResultRepo;
import com.exampal.service.QuizAttemptService;

@RestController
@RequestMapping("attempt")
@CrossOrigin("*")
public class AttemptController {
	
	@Autowired
	private QuizAttemptService quizAttemptService;
	
	@PostMapping
	public QuizAttempt createAttempt(
			@RequestHeader Long quizId,			
			Principal principal)
	{
		return quizAttemptService.createAttempt(quizId, principal);
	}
	
	@PostMapping("submit")
	public QuizAttempt submitQuizAndEvaluate(
			@RequestBody QuizAttempt quizAttempt,
			Principal principal
			)
	{
		return quizAttemptService.submitQuizAndEvaluate(quizAttempt,principal);
	}
	
	@Autowired
	private ResultRepo repo;
	@GetMapping("result")
	public Result getResult(@RequestHeader Long id)
	{
		return repo.findById(id).get();
	}

}
