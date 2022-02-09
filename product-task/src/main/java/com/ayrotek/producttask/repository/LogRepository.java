package com.ayrotek.producttask.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayrotek.producttask.model.Log;

public interface LogRepository extends MongoRepository<Log, Long>{

}
