package com.ayrotek.producttask.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayrotek.producttask.model.Product;
import com.ayrotek.producttask.model.dto.ProductDTO;
import com.ayrotek.producttask.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/save")
	ResponseEntity<String> saveProduct(@RequestBody ProductDTO productDTO) {

		productService.save(productDTO);
		return ResponseEntity.ok("Product saved");
	}

	@GetMapping("/{id}")
	ResponseEntity<Product> getProductById(@PathVariable long id) {

		return ResponseEntity.ok(productService.findByProductId(id));
	}

	@GetMapping("/all")
	ResponseEntity<List<Product>> getAllProducts() {

		return ResponseEntity.ok(productService.findAllProducts());
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<String> deleteProduct(@PathVariable long id) {
		productService.delete(id);
		return ResponseEntity.ok("Product removed");
	}

	@PutMapping("/update/{id}")
	ResponseEntity<String>  update(@RequestBody ProductDTO productDTO, @PathVariable long id) {
		productService.update(productDTO,id);
		return ResponseEntity.ok("Product updated ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
