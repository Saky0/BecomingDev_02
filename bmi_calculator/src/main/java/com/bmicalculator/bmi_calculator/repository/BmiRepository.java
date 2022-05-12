package com.bmicalculator.bmi_calculator.repository;

import com.bmicalculator.bmi_calculator.model.Bmi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BmiRepository extends MongoRepository<Bmi, String>{
    
}
