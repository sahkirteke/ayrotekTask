package com.ayrotek.producttask.repository;
  
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.ayrotek.producttask.model.Product; 
 
public interface ProductRepository extends JpaRepository<Product, Long> { 

	Optional<Product> findByProductName(String productName);
	

}
