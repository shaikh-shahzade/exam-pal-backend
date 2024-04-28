package com.exampal.service.impl;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampal.exception.ResourceNotFoundException;
import com.exampal.model.quiz.Answer;
import com.exampal.model.quiz.AttemptedQuestion;
import com.exampal.model.quiz.Quiz;
import com.exampal.model.quiz.QuizAttempt;
import com.exampal.model.quiz.Result;
import com.exampal.repo.AnswerRepository;
import com.exampal.repo.AttemptedQuestionRepo;
import com.exampal.repo.QuestionRepository;
import com.exampal.repo.QuizAttemptRepository;
import com.exampal.repo.QuizRepository;
import com.exampal.repo.ResultRepo;
import com.exampal.service.QuizAttemptService;

@Service
public class QuizAttemptImpl implements QuizAttemptService {

	@Autowired
	private QuizAttemptRepository attemptRepository;

	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private AttemptedQuestionRepo attemptedQuestionRepo;

	@Autowired
	private ResultRepo resultRepo;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	
	@Override
	public QuizAttempt createAttempt(Long quizId, Principal principal) {
		// TODO Auto-generated method stub
		Quiz quiz = quizRepository.findById(quizId).get();
		LocalDateTime startTime =  LocalDateTime.now();
		LocalDateTime endDateTime = startTime.plusMinutes(60);
		QuizAttempt quizAttempt = QuizAttempt
				.builder()
				.quiz(quiz)
				.status("Started")
				.startTime(startTime)
				.endTime(endDateTime)
				.date(LocalDate.now())
				.build();

		return attemptRepository.save(quizAttempt);
	}

	@Override
	public QuizAttempt submitQuizAndEvaluate(QuizAttempt quizAttempt, Principal principal) {
		// TODO Auto-generated method stub
		long id = quizAttempt.getId();
		QuizAttempt quizAttempt_retrieved = this.attemptRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(QuizAttempt.class.toString(), "id", id));
		
		quizAttempt_retrieved.setStatus("Completed");
		
		Result result = quizAttempt.getResult();
		
		List<AttemptedQuestion> attemptedQuestions = result.getAttemptedQuestion();
		
		
		attemptedQuestions = attemptedQuestions.stream().map(attemptQ-> {
			// save and map each question
			Answer answer = answerRepository
					.findById(attemptQ.getAnswer().getId()).orElseThrow();
			attemptQ.setAnswer(answer);
			
			attemptQ.setIsCorrect(answer.getIsCorrect());
			
			attemptQ.setQuestion(
			questionRepository
			.findById(attemptQ.getQuestion().getQuesid()).orElseThrow()
			);
			
			attemptQ.setResult(result);
			
			return attemptQ;
		}).collect(Collectors.toList());
		
		int marks = 0;
		int totalAttempted=attemptedQuestions.size();
		int correctAttempts=0;
		
		for(AttemptedQuestion at:attemptedQuestions)
			if( at.getIsCorrect()!=null &&at.getIsCorrect()==true)
				{
					marks+=10;
					correctAttempts+=1;
				}
		//result.setQuiz(quizAttempt_retrieved.getQuiz());		
		result.setCorrectAnswers(correctAttempts);
		result.setMarks(marks);
		
		result.setTimeTaken(ChronoUnit.MINUTES.between(quizAttempt_retrieved.getStartTime(), quizAttempt_retrieved.getEndTime()));
		result.setTotalAttempted(totalAttempted);
		
		result.setAttemptedQuestion(attemptedQuestions);
		//resultRepo.save(result);
		quizAttempt_retrieved.setResult(result);
		
		
		return attemptRepository.save(quizAttempt_retrieved);
	}

	@Override
	public QuizAttempt getResultById(Long id) {
		// TODO Auto-generated method stub
		return this.attemptRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(this.getClass().toString(), Result.class.toString(), id));
	}
	

}
