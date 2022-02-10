package com.ayrotek.producttask.service;
  
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ayrotek.producttask.model.Product;
import com.ayrotek.producttask.model.dto.ProductDTO;
import com.ayrotek.producttask.repository.ProductRepository;
 

@Service
@Transactional
public class ProductService {

	
	 ProductRepository productRepository; 
	 TaxService taxService;

	public ProductService(ProductRepository productRepository, 	 TaxService taxService) { 
		this.productRepository = productRepository; 
		this.taxService= taxService;
	}
	
	public void save(ProductDTO productDTO) {
		Product product = new Product(); 
		
		product.setPrice(productDTO.getPrice());
		product.setProductName(productDTO.getProductName()); 
		product.setInsertDate(new Date());
		product.setProductType(productDTO.getProductType());
		
		BigDecimal tax = taxService.calculate(productDTO.getProductType(), productDTO.getPrice());
		product.setTax(tax);
		product.setTotalPrice(productDTO.getPrice().add(tax));
		productRepository.save(product);
	}  
	
	public Product findByProductId(long id) {
		Optional<Product> optional =  productRepository.findById(id);
		if(!optional.isEmpty()) {
			return optional.get();
		}else {
			return null;
		}
		
	}
	
	public Product findByProductName(String productName) {
		Optional<Product> optional =  productRepository.findByProductName(productName);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
		
	}
	
	
	public List<Product> findAllProducts() {
		 List<Product> products = productRepository.findAll(); 
		 taxService.listProduct();
		 return products;
	} 
	  
	public void delete(long id) { 
		productRepository.deleteById(id); 
		taxService.deleteLog();
	} 

	public Product update(ProductDTO productDTO, long id) {  
		Product product = findByProductId(id);
			if(product != null) { 
			product.setPrice(productDTO.getPrice());
			product.setProductName(productDTO.getProductName()); 
			product.setInsertDate(new Date());
			product.setProductType(productDTO.getProductType());

			BigDecimal tax = taxService.calculate(productDTO.getProductType(), productDTO.getPrice());
			System.out.println(tax);
			product.setTax(tax);
			product.setTotalPrice(productDTO.getPrice().add(tax));
			
			return productRepository.save(product); 
		} 
		return null;  
	}   
	
	 
}




















