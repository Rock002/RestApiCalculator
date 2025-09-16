package com.RestApiCalculator.models.dto;

public record UserDto(
        String username,
        String password,
        String role
)
{ }
