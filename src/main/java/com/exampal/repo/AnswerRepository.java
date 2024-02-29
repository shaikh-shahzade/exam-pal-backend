package com.exampal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.quiz.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long>{

}
