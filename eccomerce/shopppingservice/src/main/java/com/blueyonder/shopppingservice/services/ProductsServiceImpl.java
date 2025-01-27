package com.blueyonder.shopppingservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.blueyonder.shopppingservice.Dto.ProductDto;
import com.blueyonder.shopppingservice.entities.Category;
import com.blueyonder.shopppingservice.entities.Product;
import com.blueyonder.shopppingservice.exceptions.CategoryNotFoundException;
import com.blueyonder.shopppingservice.repository.CategoryRepository;
import com.blueyonder.shopppingservice.repository.ProductRepository;
import java.util.Collections;

@Service
public class ProductsServiceImpl implements ProductServices {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Product addProduct(ProductDto productDto) throws CategoryNotFoundException {

		Category result=categoryRepository.findByCategoryName(productDto.getCategoryName());
		
		if(result!=null)
		{
			Product product=new Product();
			product.setProductName(productDto.getProductName());
			product.setPrice(productDto.getPrice());
			product.setDescription(productDto.getDescription());
			product.setImageAddress(productDto.getImageAddress());
			product.setCategory(result);
			product.setProductId(productDto.getProductId());

			return productRepository.save(product);
		}
		else {
			throw new CategoryNotFoundException("Catgeory Does not exist");
		}
		
	}

	@Override
	public boolean deleteProduct() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getProductById() {

		return null;
	}

	@Override
	public List<Product> getAllProductsByCategoryId(Integer categoryId) throws CategoryNotFoundException  {
		List<Product> result=productRepository.findByCategoryId(categoryId);
		if(result ==null)
		{
			throw new CategoryNotFoundException("Product Not Found Exception");
		}
		else {
			return result;
		}
		
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.getAllProducts();
	}


    @Override
    public Product updateProduct(ProductDto productDto) {
        // Validate input data
        if (productDto == null || productDto.getProductId() == null) {
            throw new IllegalArgumentException("Invalid product DTO or product ID");
        }

        // Check if the category exists
        Category category = categoryRepository.findByCategoryName(productDto.getCategoryName());
        if (category == null) {
            throw new IllegalArgumentException("Category not found: " + productDto.getCategoryName());
        }

        // Retrieve the product to update
        Product product = productRepository.findById(productDto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productDto.getProductId()));

        // Update product data
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageAddress(productDto.getImageAddress());
        product.setCategory(category);

        // Save the updated product
        Product updatedProduct = productRepository.save(product);

        // Log the update
        System.out.println("Product updated: " + updatedProduct);

        return updatedProduct;
    }




}
