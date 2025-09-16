package com.RestApiCalculator.repository;

import com.RestApiCalculator.models.entity.CalculatorRequest;
import com.RestApiCalculator.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalculatorRequestRepository extends JpaRepository<CalculatorRequest, Long> {
    List<CalculatorRequest> findByUser(User user);
}
