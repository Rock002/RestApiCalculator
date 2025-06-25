package com.RestApiCalculator.models.entity;

public class CalculatorRequest {

    private double first;
    private double second;
    private String operation;

    public double getFirst() {
        return first;
    }

    public double getSecond() {
        return second;
    }

    public String getOperation() {
        return operation;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setSecond(double second) {
        this.second = second;
    }
}
