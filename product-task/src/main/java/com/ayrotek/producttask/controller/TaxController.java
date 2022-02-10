package com.ayrotek.producttask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayrotek.producttask.model.Log;
import com.ayrotek.producttask.service.TaxService;

@RestController
@RequestMapping("/log")
public class TaxController {

	@Autowired
	TaxService taxService;
	
	@GetMapping("/list")
	public List<Log> getLog(){
		
		List<Log> logs = taxService.listLog();
		
		return logs;
	}
	
}
