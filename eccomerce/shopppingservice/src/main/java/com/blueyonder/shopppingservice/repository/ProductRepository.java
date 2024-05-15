package com.blueyonder.shopppingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blueyonder.shopppingservice.entities.Category;
import com.blueyonder.shopppingservice.entities.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
  
   @Query("SELECT p FROM Product p")
   		public List<Product> getAllProducts();
   public Product findByProductName(String productName);
   @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
   public List<Product> findByCategoryId(@Param("categoryId") int categoryId);
   
}
