package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public String index(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product){
//        product.getId();
        productService.add(product);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String goUpdate(@RequestParam int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("msg", "update complete");
        return "redirect:/";
    }
}
