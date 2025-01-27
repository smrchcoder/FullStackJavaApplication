package com.blueyonder.shopppingservice.Dto;

import com.blueyonder.shopppingservice.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {

 private Integer productId;
 private String productName;
 private Integer price;
 private String description;
 private String imageAddress;
 private String categoryName;
}
