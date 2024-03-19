package com.exampal.service;

import java.util.List;

import com.exampal.model.quiz.Category;

public interface CategoryService {

	List<Category> getAllCategories();

	Category createCategories(Category category);

}
