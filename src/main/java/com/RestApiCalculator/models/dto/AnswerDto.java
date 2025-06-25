package com.RestApiCalculator.models.dto;

public record AnswerDto (
        double first,
        double second,
        String operation,
        double answer
) { }
