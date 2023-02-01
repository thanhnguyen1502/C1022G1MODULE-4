package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SanwichController {
    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/save")
    public ModelAndView save(@RequestParam(value = "condiments", defaultValue = "") String[] arr){
        ModelAndView modelAndView = new ModelAndView("index");
        if (arr.length==0){
            modelAndView.addObject("condiments","no choise yet");
        }else {
            modelAndView.addObject("condiments", arr);
        }
        return modelAndView;
    }
}
