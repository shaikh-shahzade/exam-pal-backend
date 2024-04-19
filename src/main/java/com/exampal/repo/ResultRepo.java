package com.exampal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.quiz.Result;

public interface ResultRepo extends JpaRepository<Result, Long>{

}
