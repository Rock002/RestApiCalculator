package com.RestApiCalculator.controllers;

import com.RestApiCalculator.models.dto.MainDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainRestController {

    @GetMapping
    public List<MainDto> mainPage() {
        ArrayList<MainDto> listOfDigits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            MainDto digit = new MainDto(Integer.toString(i));
            listOfDigits.add(digit);
        }
        //  MainDto button = new MainDto("1");
        return listOfDigits;
    }

}
