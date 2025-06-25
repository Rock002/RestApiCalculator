package com.RestApiCalculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {

    public double calculateResult(double first, double second, String operation) {
        switch (operation) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                if (second != 0) {
                    return first / second;
                }
            default:
                break;
        }
        return 0;
    }

}
