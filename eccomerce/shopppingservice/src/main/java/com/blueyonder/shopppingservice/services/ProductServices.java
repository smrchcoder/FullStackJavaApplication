package com.blueyonder.shopppingservice.services;

import java.util.List;

import org.hibernate.tool.schema.spi.SchemaTruncator;

import com.blueyonder.shopppingservice.Dto.ProductDto;
import com.blueyonder.shopppingservice.entities.Product;
import com.blueyonder.shopppingservice.exceptions.CategoryNotFoundException;


public interface ProductServices {
	public Product addProduct(ProductDto productDto) throws CategoryNotFoundException;
	public boolean deleteProduct();
	public Product getProductById();
	public List<Product> getAllProductsByCategoryId(Integer categoryId) throws CategoryNotFoundException;
	public List<Product> getAllProducts();
	public Product updateProduct(ProductDto productDto);


}
