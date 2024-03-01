package com.exampal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampal.model.quiz.Question;
import com.exampal.model.quiz.Quiz;
import com.exampal.repo.QuestionRepository;
import com.exampal.repo.QuizRepository;
import com.exampal.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public List<Question> getQuestionsByQuizId(Long quizId) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId).orElse(null);
		return questionRepository.findByQuiz(quiz);
	}

	@Override
	public List<Question> createQuestions(List<Question> questions , Long quizId) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId).orElse(null);
		questions.forEach(q->q.setQuiz(quiz));
		questions = questionRepository.saveAll(questions);
		return questions;
	}

	@Override
	public List<Question> updateQuestions(List<Question> questions, Long quizId) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId).orElse(null);
		List<Question> q = questionRepository.saveAll(questions);
		
		return q;
	}

}
