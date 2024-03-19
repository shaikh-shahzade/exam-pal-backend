package com.exampal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampal.model.quiz.Category;
import com.exampal.repo.CategoryRepository;
import com.exampal.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository catRepo;
	
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return catRepo.findAll();
	}

	@Override
	public Category createCategories(Category category) {
		// TODO Auto-generated method stub
		return catRepo.save(category);
	}

}
