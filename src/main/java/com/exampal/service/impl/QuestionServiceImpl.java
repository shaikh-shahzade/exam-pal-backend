package com.exampal.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampal.exception.ResourceNotFoundException;
import com.exampal.model.quiz.Answer;
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
		Quiz quiz = quizRepository.findById(quizId).orElseThrow(()->new ResourceNotFoundException("quiz", "Id", quizId));
		return questionRepository.findByQuiz(quiz);
	}

	@Override
	public List<Question> createQuestions(List<Question> questions , Long quizId) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId).orElseThrow(()->new ResourceNotFoundException("quiz", "Id", quizId));
		questions.forEach(q->q.setQuiz(quiz));
		questions = questionRepository.saveAll(questions);
		return questions;
	}

	@Override
	public List<Question> updateQuestions(List<Question> questions, Long quizId) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId).orElseThrow(()->new ResourceNotFoundException("quiz", "Id", quizId));
		questions.forEach(q->q.setQuiz(quiz));
		List<Question> q = questionRepository.saveAll(questions);
		
		return q;
	}

	@Override
	public Set<Question> updateOrModifyQuestions(Set<Question> questions, Quiz quiz) {
		// TODO Auto-generated method stub
		
		

		for (Question q2 : quiz.getQuestion()) {
			q2.setQuiz(quiz);
			for (Answer a : q2.getAnswers())
				a.setQuestion(q2);

			q2.setAnswers(q2.getAnswers());
		}
		return quiz.getQuestion(); 
	}

}
