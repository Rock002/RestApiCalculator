package com.RestApiCalculator.controllers;

import com.RestApiCalculator.models.entity.CalculatorRequest;
import com.RestApiCalculator.service.CalculateService;
import com.RestApiCalculator.service.CalculatorRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class mainController {

    private final CalculateService calculateService;
    private final CalculatorRequestService calculatorRequestService;

    public mainController(CalculateService calculateService, CalculatorRequestService calculatorRequestService) {
        this.calculateService = calculateService;
        this.calculatorRequestService = calculatorRequestService;
    }


    @GetMapping("/api/{answer}")
    public String mainPage(@PathVariable double answer, Model model) {
        model.addAttribute("answer", answer);
        return "main";
    }

    @GetMapping("/api")
    public String emptyMainPage(Model model) {
        model.addAttribute("answer", "none");
        return "main";
    }

    @PostMapping("/api/postresult")
    public String answer(CalculatorRequest request) {
        double answer = calculateService.calculateResult(
                request.getFirst(),
                request.getSecond(),
                request.getOperation()
        );
        request.setResult(answer);
        calculatorRequestService.saveOperation(request);
        return "redirect:/api/" + Double.toString(answer);
    }
}
