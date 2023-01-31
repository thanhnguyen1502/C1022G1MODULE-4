package com.example.controller;

import com.example.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CurrencyController {
    @Autowired
    private ICurrencyService currencyService;

    @GetMapping("/goConvert")
    public String showFormCurrencyConversion() {
        return "conversion-form";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam double usd, double rate, Model model) {
        double result = currencyService.convert(usd, rate);
        model.addAttribute("result", result);
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        return "conversion-form";
    }
}
