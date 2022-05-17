package com.bmicalculator.bmi_calculator.view.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.bmicalculator.bmi_calculator.service.BmiService;
import com.bmicalculator.bmi_calculator.shared.BmiDto;
import com.bmicalculator.bmi_calculator.view.model.BmiRequest;
import com.bmicalculator.bmi_calculator.view.model.BmiResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/bmi")
public class BmiController {

    @Autowired
    private BmiService service;

    @GetMapping
    public ResponseEntity<List<BmiResponse>> getAllBmi() {
        ModelMapper mapper = new ModelMapper();

        List<BmiDto> dtoList = service.getAllBmi();
        
        List<BmiResponse> responseList = new ArrayList<>();
        responseList = dtoList.stream()
            .map(bmi -> mapper.map(bmi, BmiResponse.class))
            .collect(Collectors.toList());

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<BmiResponse> getBmiById(@PathVariable String id) {
        ModelMapper mapper = new ModelMapper();

        Optional<BmiDto> dto = service.getBmiById(id);

        if(dto.isPresent()) {
            BmiResponse bmiResponse = mapper.map(dto.get(), BmiResponse.class);
            return new ResponseEntity<BmiResponse>(bmiResponse, HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BmiResponse> insertBmi(@RequestBody @Valid BmiRequest bmi) {
        ModelMapper mapper = new ModelMapper();

        BmiDto dto = mapper.map(bmi, BmiDto.class);
        dto = service.insertBmi(dto);

        return new ResponseEntity<BmiResponse>(mapper.map(dto, BmiResponse.class), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBmiById(@PathVariable String id) {
        service.deleteBmiById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
