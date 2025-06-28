package com.RestApiCalculator.repository;

import com.RestApiCalculator.models.entity.CalculatorRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRequestRepository extends JpaRepository<CalculatorRequest, Long> {
}
