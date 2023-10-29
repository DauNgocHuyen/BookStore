package com.quynhanh.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	// Get all category
	@Override
	public List<Category> getAlls() {
		return categoryRepository.findAll();
	}

}
