package com.example.execrise.controller;

import com.example.execrise.model.Catelory;
import com.example.execrise.service.ICateloryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CateloryController {
    @Autowired
    private ICateloryService cateloryService;

    @GetMapping("/catelory")
    public String showList(Model model){
        List<Catelory> cateloryList = cateloryService.findAll();
        model.addAttribute("cateloryList", cateloryList);
        return "catelory-home";
    }
}
