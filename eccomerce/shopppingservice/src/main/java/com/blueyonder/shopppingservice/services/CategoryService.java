package com.blueyonder.shopppingservice.services;

import java.util.List;

import com.blueyonder.shopppingservice.Dto.CategoryDto;
import com.blueyonder.shopppingservice.entities.Category;

public interface CategoryService {
	public Category addCategory(CategoryDto categoryDto);

	public boolean deleteCustomer();

	public Category getCategoryById(Integer categoryId);

	public List<String> getAllCategory();
	
	public List<Category> getAllCategories();

}
