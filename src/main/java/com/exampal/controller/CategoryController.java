package com.exampal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampal.model.quiz.Category;
import com.exampal.service.CategoryService;

@RestController
@RequestMapping("category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping()
	public List<Category> getAllCategory()
	{
		return this.categoryService.getAllCategories();
	}
	@PostMapping()
	public Category createCategory(@RequestBody Category category)
	{
		return this.categoryService.createCategories(category);
	}
	

}
