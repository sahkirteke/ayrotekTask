package com.ayrotek.producttask.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "log")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
	  
	@Id
	private long id;
	
	private String info; 
	
	private LocalDateTime logTime;
	
	
}
