package com.blueyonder.shopppingservice.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blueyonder.shopppingservice.exceptions.CategoryNotFoundException;
import com.blueyonder.shopppingservice.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandlerCode {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public String handleProductNotFoundException() {
		return "Product doesn't exist";
	}

	@ExceptionHandler(CategoryNotFoundException.class)
	public String handleCategoryNotFoundException() {
		return "Category doesn't exist";
	}


}
