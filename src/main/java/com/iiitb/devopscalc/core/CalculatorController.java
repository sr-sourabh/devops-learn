package com.iiitb.devopscalc.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CalculatorController {
    @GetMapping(value = "/")
    public String showForm(Model model) {
        log.info("Adding dummy request model");
        RequestDto requestDto = new RequestDto();
        model.addAttribute("request", requestDto);
        return "index";
    }

    @PostMapping(value = "/getResult")
    public String getResult(@ModelAttribute("request") RequestDto request, Model model) {
        int op = request.getOperation();
        int number = request.getNumber();

        double result = 0;
        if (op == 1) {
            result = Math.log(number);
        } else if (op == 2) {
            result = Math.sqrt(number);
        } else if (op == 3) {
            result = getFactorial(number);
        } else if (op == 4) {
            result = Math.pow(number, request.getBase());
        }
        log.info("Request: {} ; Result: {}", request.toString(), result);
        model.addAttribute("result", result);
        return "index";
    }

    private double getFactorial(int number) {
        double ans = 1;
        while (number > 0) {
            ans *= number;
            number--;
        }
        return ans;
    }

}
