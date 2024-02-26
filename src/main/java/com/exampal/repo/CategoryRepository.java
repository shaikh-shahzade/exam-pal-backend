package com.exampal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampal.model.quiz.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
