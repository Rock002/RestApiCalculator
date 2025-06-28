package com.RestApiCalculator.controllers;

import com.RestApiCalculator.models.dto.AnswerDto;
import com.RestApiCalculator.models.entity.CalculatorRequest;
import com.RestApiCalculator.service.CalculateService;
import com.RestApiCalculator.service.CalculatorRequestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainRestController {

    private final CalculateService calculateService;
    private final CalculatorRequestService calculatorRequestService;

    public MainRestController(CalculateService calculateService, CalculatorRequestService calculatorRequestService) {
        this.calculateService = calculateService;
        this.calculatorRequestService = calculatorRequestService;
    }

    @GetMapping("/history")
    public List<AnswerDto> historyOfRequests () {
        List<CalculatorRequest> history =  calculatorRequestService.listOfRequsts();
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
}
