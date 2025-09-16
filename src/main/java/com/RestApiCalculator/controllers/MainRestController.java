package com.RestApiCalculator.controllers;

import com.RestApiCalculator.models.dto.AnswerDto;
import com.RestApiCalculator.models.dto.UserDto;
import com.RestApiCalculator.models.entity.CalculatorRequest;
import com.RestApiCalculator.models.entity.User;
import com.RestApiCalculator.service.CalculateService;
import com.RestApiCalculator.service.CalculatorRequestService;
import com.RestApiCalculator.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainRestController {

    private final UserService userService;
    private final CalculateService calculateService;
    private final CalculatorRequestService calculatorRequestService;

    public MainRestController(UserService userService, CalculateService calculateService, CalculatorRequestService calculatorRequestService) {
        this.userService = userService;
        this.calculateService = calculateService;
        this.calculatorRequestService = calculatorRequestService;
    }

    @GetMapping("/history")
    public List<AnswerDto> historyOfRequests (Authentication authentication) {
        String username = authentication.getName();
        User currentUser = calculatorRequestService.getUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("not found"));
        List<CalculatorRequest> history =  calculatorRequestService
                .listOfRequstsByUser(currentUser);
        List<AnswerDto> resultHistory = new ArrayList<>();
        for (CalculatorRequest request : history) {
            AnswerDto DtoRequest = new AnswerDto(
                    request.getFirst(),
                    request.getSecond(),
                    request.getOperation(),
                    request.getResult()
            );
            resultHistory.add(DtoRequest);
        }
        return resultHistory;
    }

    @GetMapping("/profile")
    public UserDto userProfile(Authentication authentication) {
        User currentUser = calculatorRequestService.getUserByUsername(authentication.getName())
                .orElseThrow(() -> new UsernameNotFoundException("not found"));
        UserDto user = new UserDto(
                currentUser.getUsername(),
                currentUser.getPassword(),
                currentUser.getRoles()
        );
        return user;
    }

}
