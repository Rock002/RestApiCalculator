package com.RestApiCalculator.service;

import com.RestApiCalculator.models.entity.CalculatorRequest;
import com.RestApiCalculator.models.entity.User;
import com.RestApiCalculator.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByName(username);
    }

}
