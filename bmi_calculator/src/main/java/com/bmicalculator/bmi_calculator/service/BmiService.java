package com.bmicalculator.bmi_calculator.service;

import java.util.List;
import java.util.Optional;

import com.bmicalculator.bmi_calculator.shared.BmiDto;

public interface BmiService {

    List<BmiDto> getAllBmi();
    Optional<BmiDto> getBmiById(String id);
    BmiDto insertBmi(BmiDto bmi);
    void deleteBmiById(String id);
}
