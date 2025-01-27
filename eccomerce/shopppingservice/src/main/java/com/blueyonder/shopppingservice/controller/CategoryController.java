package com.blueyonder.shopppingservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.shopppingservice.Dto.CategoryDto;
import com.blueyonder.shopppingservice.Dto.UpdateDetailsDto;
import com.blueyonder.shopppingservice.entities.Category;
import com.blueyonder.shopppingservice.services.CategoryService;
import com.netflix.infix.lang.infix.antlr.EventFilterParser.null_predicate_return;

import jakarta.ws.rs.GET;

@RestController
@RequestMapping("/category")

public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/addCategory")
	public ResponseEntity<String> addCategory(@RequestBody CategoryDto categoryDto) {
        System.out.println(categoryDto.toString());
		Category result = categoryService.addCategory(categoryDto);
		if (result != null) {
			return new ResponseEntity<>("Category Added sucessfull", HttpStatus.OK);
		}

		return new ResponseEntity<>("Error Adding Category", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/allcategories")
	public ResponseEntity<List<String>> getAllCategoryNames() {
		List<String> result = new ArrayList<String>();
		result = categoryService.getAllCategory();
		return new ResponseEntity<List<String>>(result, HttpStatus.CREATED);
	}

	@PostMapping("/updatecategorybyfield")
	public ResponseEntity<Category> updateCategoryByField(@RequestBody UpdateDetailsDto updateDetailsDto) {
		return null;
		// Your code logic goes here
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Category>> getAllcategories()
	{  
		System.out.println("Request is received here");
		List<Category> result=categoryService.getAllCategories();
		if(result!=null)
		{
			return new ResponseEntity<List<Category>>(result,HttpStatus.OK);
		}
		return null;
	}
}
