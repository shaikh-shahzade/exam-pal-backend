package com.exampal.service.impl;

import java.security.Principal;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.exampal.exception.ResourceNotFoundException;
import com.exampal.model.User;
import com.exampal.model.quiz.Answer;
import com.exampal.model.quiz.Category;
import com.exampal.model.quiz.Question;
import com.exampal.model.quiz.Quiz;
import com.exampal.repo.AnswerRepository;
import com.exampal.repo.CategoryRepository;
import com.exampal.repo.QuestionRepository;
import com.exampal.repo.QuizRepository;
import com.exampal.repo.UserRepository;
import com.exampal.service.QuizService;

import jakarta.transaction.Transactional;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizRepository quizRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	QuestionRepository questionRepo;

	@Autowired
	AnswerRepository answerRepo;

	@Autowired
	CategoryRepository catRepository;

	@Autowired
	QuestionServiceImpl questionServiceImpl;
	
	@Override
	public Quiz createQuiz(Quiz quiz, String username) {
		// TODO Auto-generated method stub
		User user = userRepo.findUserByUsername(username);
		quiz.setHost(user);
		Quiz q = quizRepo.save(quiz);
		return q;
	}

	@Override
	public List<Quiz> getAllQuiz(Integer page, Integer count, String sortBy, String sorting, String searchKey,
			Boolean host, Principal principal) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(page, count, Sort.by(Direction.fromString(sorting), sortBy));

		Page<Quiz> q = null;
		if (host && principal != null) {
			User user = userRepo.findUserByUsername(principal.getName());
			if (searchKey.isEmpty())
				q = quizRepo.findAllByHost(pageable, user);
			else
				q = quizRepo.findByTitleIgnoreCaseContainingAndHost(searchKey, pageable, user);

		} else if (!host) {
			if (searchKey.isEmpty())
				q = quizRepo.findAll(pageable);
			else
				q = quizRepo.findByTitleIgnoreCaseContaining(searchKey, pageable);

		}

		return q != null ? q.toList() : null;
	}

	@Override
	public Quiz getQuizById(Long qid) {
		// TODO Auto-generated method stub
		Quiz q = quizRepo.findById(qid).orElseThrow(() -> new ResourceNotFoundException("Quiz", "ID", qid));
		return q;
	}

	@Override
	public Quiz updateQuiz(Long qid, Quiz quiz) {
		// TODO Auto-generated method stub
		Quiz q = quizRepo.findById(qid).orElseThrow(() -> new ResourceNotFoundException("Quiz", "ID", qid));
		q.setActive(quiz.isActive());
		q.setDescription(quiz.getDescription());
		q.setMaxMarks(quiz.getMaxMarks());
		q.setMaxTime(quiz.getMaxTime());
		q.setNoOfQuestions(quiz.getNoOfQuestions());
		q.setTitle(quiz.getTitle());
		q.setLastDate(quiz.getLastDate());
		q.setStartDate(quiz.getStartDate());

		if (quiz.getCategory() != null)
			q.setCategory(catRepository.findById(quiz.getCategory().getCid()).get());
		
		q.setPassingMarks(quiz.getPassingMarks());
		
		Set<Question> questions = questionServiceImpl.updateOrModifyQuestions(quiz.getQuestion(), quiz);
		

		q.setQuestion(questions);
		q = quizRepo.saveAndFlush(q);
		System.out.print(q.getCategory().getTitle());
		return q;
	}

	@Override
	public Quiz deleteQuiz(Long qid) {
		// TODO Auto-generated method stub
		Quiz q = quizRepo.findById(qid).orElseThrow(() -> new ResourceNotFoundException("Quiz", "ID", qid));
		quizRepo.delete(q);
		return q;
	}

}
