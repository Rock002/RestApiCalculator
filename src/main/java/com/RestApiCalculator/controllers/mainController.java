package com.RestApiCalculator.controllers;

import com.RestApiCalculator.models.entity.CalculatorRequest;
import com.RestApiCalculator.models.entity.User;
import com.RestApiCalculator.service.CalculateService;
import com.RestApiCalculator.service.CalculatorRequestService;
import com.RestApiCalculator.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class mainController {

    private final CalculateService calculateService;
    private final CalculatorRequestService calculatorRequestService;
    private final UserService userService;

    public mainController(CalculateService calculateService, CalculatorRequestService calculatorRequestService, UserService userService) {
        this.calculateService = calculateService;
        this.calculatorRequestService = calculatorRequestService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
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

    @GetMapping("/registration")
    public String registrationPage() {
        return "register";
    }

    @PostMapping("/postregistration")
    public String postregistrationPage(User user) {
        user.setRoles("USER");
        userService.saveUser(user);
        return "redirect:/api";
    }

    @PostMapping("/api/postresult")
    public String answer(CalculatorRequest request, Authentication authentication) {
        double answer = calculateService.calculateResult(
                request.getFirst(),
                request.getSecond(),
                request.getOperation()
        );
        request.setResult(answer);
        String username = authentication.getName();
        User currentUser = calculatorRequestService.getUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("not found"));
        request.setUser(currentUser);
        calculatorRequestService.saveOperation(request);
        return "redirect:/api/" + Double.toString(answer);
    }
}
