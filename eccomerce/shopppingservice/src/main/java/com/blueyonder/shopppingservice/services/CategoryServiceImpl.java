package com.blueyonder.shopppingservice.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.shopppingservice.Dto.CategoryDto;
import com.blueyonder.shopppingservice.entities.Category;
import com.blueyonder.shopppingservice.entities.Product;
import com.blueyonder.shopppingservice.repository.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Category addCategory(CategoryDto categoryDto) {

		Category category =new Category();
		category.setCategoryName(categoryDto.getCategoryName());
		category.setDescription(categoryDto.getDescription());
		category.setProductList(categoryDto.getProductList());
		return categoryRepository.save(category);
	}

	@Override
	public boolean deleteCustomer() {

		return false;
	}

	@Override
	public Category getCategoryById(Integer categoryId) {

		return null;
	}

	@Override
	public List<String> getAllCategory() {

		return categoryRepository.findAllCategoryNames();
	}

	@Override
	public List<Category> getAllCategories() {
		
		return categoryRepository.getAllCategories();
	}

}
