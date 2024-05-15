package com.blueyonder.shopppingservice.Dto;

import java.util.List;

import com.blueyonder.shopppingservice.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

	private Integer categoryId;
	private String categoryName ;
	private String description ;
	private List<Product> productList;
	
}
