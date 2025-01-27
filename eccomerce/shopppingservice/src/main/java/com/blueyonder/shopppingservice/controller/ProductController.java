package com.blueyonder.shopppingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.shopppingservice.Dto.ProductDto;
import com.blueyonder.shopppingservice.entities.Product;
import com.blueyonder.shopppingservice.exceptions.CategoryNotFoundException;
import com.blueyonder.shopppingservice.services.ProductServices;

@RestController
@RequestMapping("/products")
//@CrossOrigin(origins="http://localhost:3000")
public class ProductController {
	@Autowired
	private ProductServices productServices;

	@PostMapping("/addproduct")
	public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) throws CategoryNotFoundException {
		System.out.println(productDto.toString());
		Product product = productServices.addProduct(productDto);
		if (product == null) {
			return new ResponseEntity<String>("Product Not Added Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Product Added Successfully", HttpStatus.OK);
	}

	@GetMapping("/getAllProductsByCategoryId")
	public ResponseEntity<List<Product>> getMethodName(@RequestParam("categoryId") Integer categoryId) throws CategoryNotFoundException {
		System.out.println(categoryId);
		List<Product> result = productServices.getAllProductsByCategoryId(categoryId);

		return new ResponseEntity<List<Product>>(result, HttpStatus.OK);
	}

	@GetMapping("/allproducts")
	public ResponseEntity<List<Product>> allProduct() {
		List<Product> result = productServices.getAllProducts();
		if (result == null) {
			return null;
		}
		return new ResponseEntity<List<Product>>(result, HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto)
	{
		Product product=productServices.updateProduct(productDto);
		if(product!=null)
		{
			return new ResponseEntity<String>("Product Details Updated Sucessfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Updation was not Possible ",HttpStatus.BAD_REQUEST);
	}
}
