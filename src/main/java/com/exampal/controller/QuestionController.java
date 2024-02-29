package com.exampal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampal.model.quiz.Question;

@RestController
@RequestMapping("question")
public class QuestionController {

	@GetMapping("quiz/{quizId}")
	public List<Question> getQuestionByQuiz(@PathVariable Long quizId)
	{
		return null;
	}
	@PostMapping()
	public List<Question> createQuestions(@RequestBody List<Question> questions)
	{
		return null;
	}
	@PutMapping()
	public List<Question> updateQuestions(@RequestBody List<Question> questions)
	{
		return null;
	}
	@DeleteMapping("{id}")
	public List<Question> deleteQuestions(@PathVariable Long id)
	{
		return null;
	}
}
