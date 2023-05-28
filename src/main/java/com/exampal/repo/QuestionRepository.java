package com.exampal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
