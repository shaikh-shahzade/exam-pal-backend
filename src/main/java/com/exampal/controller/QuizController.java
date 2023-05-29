package com.exampal.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampal.model.Quiz;
import com.exampal.repo.UserRepository;
import com.exampal.service.QuizService;

@RestController
@RequestMapping("quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	
	@GetMapping("")
	public	List<Quiz> getAllQuiz()
	{
		return quizService.getAllQuiz();
	}
	
	@GetMapping("id")
	public	Quiz getQuizById(@RequestHeader Long id)
	{
		return quizService.getQuizById(id);
	}
	
	@PostMapping("")
	public	Quiz createQuiz(@RequestBody Quiz quiz , Principal principal)
	{
		
		return quizService.createQuiz(quiz , principal.getName());
	}
	
	@PutMapping("")
	public	Quiz updateQuiz(@RequestHeader Long id , @RequestBody Quiz quiz)
	{
		return quizService.updateQuiz(id, quiz);
	}
	
	@DeleteMapping("")
	public	Quiz deleteQuiz(@RequestHeader Long id )
	{
		return quizService.deleteQuiz(id);
	}
}
