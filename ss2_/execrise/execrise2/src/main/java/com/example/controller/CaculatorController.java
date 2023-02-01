package com.example.controller;

import com.example.service.ICaculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CaculatorController {
    @Autowired

    private ICaculationService caculationService;
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/")
    public ModelAndView result(@RequestParam String number1, String number2, String condition){
        return new ModelAndView("index", "resutl", caculationService.result(number1,number2,condition));
    }
}