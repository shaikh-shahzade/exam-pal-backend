package com.exampal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampal.exception.ResourceNotFoundException;
import com.exampal.model.Category;
import com.exampal.model.Question;
import com.exampal.model.Quiz;
import com.exampal.model.User;
import com.exampal.repo.CategoryRepository;
import com.exampal.repo.QuestionRepository;
import com.exampal.repo.QuizRepository;
import com.exampal.repo.UserRepository;
import com.exampal.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizRepository quizRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	QuestionRepository questionRepo;
	
	@Autowired
	CategoryRepository catRepository;
	
	@Override
	public Quiz createQuiz(Quiz quiz , String username) {
		// TODO Auto-generated method stub
		User user = userRepo.findUserByUsername(username);
		
		quiz.setUser(user);
		List<Question> questions;
		if(quiz.getQuestion()!=null)
		{
			questions= questionRepo.saveAll(quiz.getQuestion());
			quiz.setQuestion(questions);

		}
		
		Category cat = quiz.getCategory();
		//System.out.println(cat+"DDDDDDDDDD");
			if(cat!=null&&(cat.getCid()==null||!catRepository.existsById(cat.getCid())))
				cat = catRepository.save(cat);
		
		quiz.setCategory(cat);
		
		Quiz q = quizRepo.save(quiz);
		return q;
	}

	@Override
	public List<Quiz> getAllQuiz() {
		// TODO Auto-generated method stub
		List<Quiz> quizes = quizRepo.findAll();
		return quizes;
	}

	@Override
	public Quiz getQuizById(Long qid) {
		// TODO Auto-generated method stub
		Quiz q =  quizRepo.findById(qid).orElseThrow(()->new ResourceNotFoundException("Quiz", "ID", qid));
		return q;
	}

	@Override
	public Quiz updateQuiz(Long qid, Quiz quiz) {
		// TODO Auto-generated method stub
		Quiz q =  quizRepo.findById(qid).orElseThrow(()->new ResourceNotFoundException("Quiz", "ID", qid));
		q.setActive(quiz.isActive());
		q.setDescription(quiz.getDescription());
		q.setMaxMarks(quiz.getMaxMarks());
		q.setMaxTime(quiz.getMaxTime());
		q.setNoOfQuestions(quiz.getNoOfQuestions());
		q.setTitle(quiz.getTitle());
		
		q = quizRepo.save(q);
		return q;
	}

	@Override
	public Quiz deleteQuiz(Long qid) {
		// TODO Auto-generated method stub
		Quiz q = quizRepo.findById(qid).orElseThrow(()->new ResourceNotFoundException("Quiz", "ID", qid));
		quizRepo.delete(q);
		return q;
	}

	
}
