package com.ayrotek.producttask.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.ayrotek.producttask.enums.ProductType;
import com.ayrotek.producttask.model.Log;
import com.ayrotek.producttask.repository.LogRepository;

@Service
public class TaxService { 
	
	//LogReposiyory
	//Log get 
	LogRepository logRepository; 
	
	public TaxService(LogRepository logRepository) {
		super();
		this.logRepository = logRepository;
	} 
	Log log = new Log();
	public BigDecimal calculate(ProductType productType, BigDecimal price) {
		
		BigDecimal calculatedTax; 
		if(price==null) {
			//Price can't be null!!! + logtime,
			log.setInfo("Price can't be null");
			log.setLogTime(LocalDateTime.now());
			logRepository.save(log);
			throw new IllegalArgumentException("Price can't be null!!!"); 
		}
		//ürün tipi isteği ve fiyatı gelidi
		log.setId(new Random().nextLong()+new Random().nextLong());
		log.setInfo("Product type : " +productType+ " and product price: " +price + " has come");
		log.setLogTime(LocalDateTime.now());
		logRepository.save(log);
		// LocalDateTime.now()
		switch (productType) {
		case ELECTRONICS:
			//
			calculatedTax = price.multiply(new BigDecimal("1.6"));
			//hesaplanan Tax + hesaplanma zamanı
			log.setId(new Random().nextLong()+new Random().nextLong());
			log.setInfo("Calculated tax: " +calculatedTax );
			log.setLogTime(LocalDateTime.now());
			logRepository.save(log);
			System.out.println("asdadasdadadadasd adasd ");
			return calculatedTax;

		case BOOK:
			log.setId(new Random().nextLong()+new Random().nextLong());
			calculatedTax = price.multiply(new BigDecimal("0.3"));
			log.setInfo("Calculated tax: " +calculatedTax );
			log.setLogTime(LocalDateTime.now());
			logRepository.save(log);
			return calculatedTax;

		case CAR:
			log.setId(new Random().nextLong()+new Random().nextLong());
			calculatedTax = price.multiply(new BigDecimal("4.6"));
			log.setInfo("Calculated tax: " +calculatedTax );
			log.setLogTime(LocalDateTime.now());
			logRepository.save(log);
			System.out.println(log);
			return calculatedTax;

		case HOMESTUFF:
			log.setId(new Random().nextLong()+new Random().nextLong());
			calculatedTax = price.multiply(new BigDecimal("4.6"));
			log.setInfo("Calculated tax: " +calculatedTax );
			log.setLogTime(LocalDateTime.now());
			logRepository.save(log);
			return calculatedTax; 
			
		default:
			//uruntipi yanlış girilmiştir + logtime 
			log.setId(new Random().nextLong()+new Random().nextLong());
			log.setInfo("Product type has been wrong");
			log.setLogTime(LocalDateTime.now());
			logRepository.save(log); 
			return null;
		}
		
		
		
	}
	public void deleteLog() {
			
		log.setId(new Random().nextLong()+new Random().nextLong());
		log.setInfo("Product type has been deleted");
		log.setLogTime(LocalDateTime.now());
		logRepository.save(log); 
		
	}
	public void listProduct() {
		
		log.setId(new Random().nextLong()+new Random().nextLong());
		log.setInfo("Product has been listed");
		log.setLogTime(LocalDateTime.now());
		logRepository.save(log); 
		
	}


	 

	
}
