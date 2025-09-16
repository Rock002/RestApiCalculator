package com.RestApiCalculator.service;

import com.RestApiCalculator.models.entity.CalculatorRequest;
import com.RestApiCalculator.models.entity.User;
import com.RestApiCalculator.repository.CalculatorRequestRepository;
import com.RestApiCalculator.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalculatorRequestService {
    private final CalculatorRequestRepository calculatorRequestRepository;
    private final UserRepository userRepository;

    public CalculatorRequestService(CalculatorRequestRepository calculatorRequestRepository, UserRepository userRepository) {
        this.calculatorRequestRepository = calculatorRequestRepository;
        this.userRepository = userRepository;
    }

    public void saveOperation(CalculatorRequest request) {
        calculatorRequestRepository.save(request);
    }

    public List<CalculatorRequest> listOfRequstsByUser(User user) {
        return calculatorRequestRepository.findByUser(user);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
