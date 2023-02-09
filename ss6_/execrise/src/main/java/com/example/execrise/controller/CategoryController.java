package com.example.execrise.controller;

import com.example.execrise.model.Category;
import com.example.execrise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public String showList(Model model){
        List<Category> cateloryList = categoryService.findAll();
        model.addAttribute("categoryList", cateloryList);
        return "category-home";
    }
}
