package com.bmicalculator.bmi_calculator.view.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bmicalculator.bmi_calculator.service.BmiService;
import com.bmicalculator.bmi_calculator.shared.BmiDto;
import com.bmicalculator.bmi_calculator.view.model.BmiResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/bmi")
public class BmiController {
    
    @Autowired
    private BmiService service;

    @GetMapping
    public ResponseEntity<List<BmiResponse>> getMethodName() {
        ModelMapper mapper = new ModelMapper();

        List<BmiDto> dtoList = service.getAllBmi();
        
        List<BmiResponse> responseList = new ArrayList<>();
        responseList = dtoList.stream()
            .map(bmi -> mapper.map(bmi, BmiResponse.class))
            .collect(Collectors.toList());

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
    
}
