package com.bmicalculator.bmi_calculator.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bmicalculator.bmi_calculator.model.Bmi;
import com.bmicalculator.bmi_calculator.repository.BmiRepository;
import com.bmicalculator.bmi_calculator.shared.BmiDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BmiServiceImpl implements BmiService{

    @Autowired
    private BmiRepository repo;

    @Override
    public List<BmiDto> getAllBmi() {
        ModelMapper mapper = new ModelMapper();

        return repo.findAll().stream()
            .map(bmi -> mapper.map(bmi, BmiDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<BmiDto> getBmiById(String id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Bmi> optional = repo.findById(id);

        if(optional.isPresent()) {
            Optional<BmiDto> optDto = Optional.of(mapper.map(optional.get(), BmiDto.class));

            return optDto;
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public BmiDto insertBmi(BmiDto bmi) {
        ModelMapper mapper = new ModelMapper();

        Bmi newBmi = mapper.map(bmi, Bmi.class);
        newBmi = repo.save(newBmi);

        return mapper.map(newBmi, BmiDto.class);
    }

    @Override
    public void deleteBmiById(String id) {
        repo.deleteById(id);
    }

    
    
}
