package com.bmicalculator.bmi_calculator.shared;

public class BmiDto {
    private String id;
    private float weight;
    private float height;
    private float bmiPerformance;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
