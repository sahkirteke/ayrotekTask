package com.ayrotek.producttask.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ayrotek.producttask.enums.ProductType;

import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// @column name and table
	private String productName;

	private BigDecimal price;

	private BigDecimal tax;

	private BigDecimal totalPrice;
	
	
	

	@Enumerated(EnumType.STRING)
	private ProductType productType;

	@Temporal(TemporalType.DATE)
	private Date insertDate;

	 
}
