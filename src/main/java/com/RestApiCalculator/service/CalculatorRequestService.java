package com.RestApiCalculator.service;

import com.RestApiCalculator.models.entity.CalculatorRequest;
import com.RestApiCalculator.repository.CalculatorRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorRequestService {
    private final CalculatorRequestRepository repository;

    public CalculatorRequestService(CalculatorRequestRepository repository) {
        this.repository = repository;
    }

    public void saveOperation(CalculatorRequest request) {
        repository.save(request);
    }

    public List<CalculatorRequest> listOfRequsts() {
        return repository.findAll();
    }
}
