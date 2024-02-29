package com.exampal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampal.model.quiz.Question;
import com.exampal.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("quiz/{quizId}")
	public List<Question> getQuestionsByQuiz(@PathVariable Long quizId)
	{
		return questionService.getQuestionsByQuizId(quizId);
	}
	@PostMapping("quiz/{quizId}")
	public List<Question> createQuestions(
			@RequestBody List<Question> questions,
			@PathVariable Long quizId
			)
	{
		return questionService.createQuestions(questions,quizId);
	}
	@PutMapping("quiz/{quizId}")
	public List<Question> updateQuestions(
			@RequestBody List<Question> questions,
			@PathVariable Long quizId
			)
	{
		return null;
	}
	@DeleteMapping("{id}")
	public List<Question> deleteQuestions(@PathVariable Long id)
	{
		return null;
	}
}
