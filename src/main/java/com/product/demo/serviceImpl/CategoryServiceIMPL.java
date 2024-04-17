package com.product.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.dao.CategoryDao;
import com.product.demo.entity.Category;
import com.product.demo.service.CategoryService;

@Service
public class CategoryServiceIMPL implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public boolean saveCategory(Category category) {
		boolean isAdded = categoryDao.saveCategory(category);
		return isAdded;
	}

}
