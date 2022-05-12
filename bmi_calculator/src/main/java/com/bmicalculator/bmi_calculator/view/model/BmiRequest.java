package com.bmicalculator.bmi_calculator.view.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class BmiRequest {
    @DecimalMin(value = "1.0", message = "The Weight field can't be less than 1.0 Kg")
    @NotNull(message = "The Weight Field can't be Null!")
    private float weight;
    @DecimalMin(value = "0.3", message = "The Weight Height can't be less than 0.3 m")
    @NotNull(message = "The Height Field can't be Null!")
    private float height;
    @DecimalMin(value = "0.0", message = "The Bmi Height can't be less than 0.0")
    @NotNull(message = "The Bmi Field can't be Null!")
    private float bmiPerformance;

    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public float getBmiPerformance() {
        return bmiPerformance;
    }
    public void setBmiPerformance(float bmiPerformance) {
        this.bmiPerformance = bmiPerformance;
    }
}
