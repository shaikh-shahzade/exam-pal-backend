package com.exampal.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampal.model.quiz.QuizAttempt;
import com.exampal.service.QuizAttemptService;

@RestController
@CrossOrigin("*")
@RequestMapping("attempt")
public class AttemptController {
	
	@Autowired
	private QuizAttemptService quizAttemptService;
	
	@PostMapping("")
	public QuizAttempt createAttempt(@RequestBody QuizAttempt quizAttempt, Principal principal)
	{
		return quizAttemptService.createAttempt(quizAttempt,principal);
	}

}
