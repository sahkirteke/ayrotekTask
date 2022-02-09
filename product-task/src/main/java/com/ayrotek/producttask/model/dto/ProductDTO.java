package com.ayrotek.producttask.model.dto;

import java.math.BigDecimal;

import com.ayrotek.producttask.enums.ProductType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Long id;

	private String productName;

	private BigDecimal price;
	
	private BigDecimal tax;

	private BigDecimal totalPrice;

	private ProductType productType;

	
}
