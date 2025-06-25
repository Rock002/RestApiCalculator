package com.RestApiCalculator.controllers;

import com.RestApiCalculator.models.dto.AnswerDto;
import com.RestApiCalculator.service.CalculateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainRestController {

    private final CalculateService calculateService;

    public MainRestController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

//    @GetMapping("/history")
//    public List<AnswerDto> testPage() {
//        ArrayList<AnswerDto> listOfDigits = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            AnswerDto digit = new AnswerDto(
//
//            );
//            listOfDigits.add(digit);
//        }
//        //  MainDto button = new MainDto("1");
//        return listOfDigits;
//    }
}
