package com.exampal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.quiz.AttemptedQuestion;

public interface AttemptedQuestionRepo extends JpaRepository<AttemptedQuestion, Long>{

}
