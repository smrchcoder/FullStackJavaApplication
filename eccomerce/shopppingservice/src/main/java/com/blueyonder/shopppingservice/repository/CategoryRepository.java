package com.blueyonder.shopppingservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blueyonder.shopppingservice.entities.Category;
@Repository

public interface CategoryRepository extends CrudRepository<Category, Integer>{
	public Optional<Category> findById(Integer categoryId);
	  @Query("SELECT c.categoryName FROM Category c")
	    List<String> findAllCategoryNames();
	 public  Category findByCategoryName(String categoryName);
	 @Query("SELECT c FROM Category c")
	 List<Category> getAllCategories();

}
