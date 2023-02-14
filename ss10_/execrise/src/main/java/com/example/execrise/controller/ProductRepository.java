package com.example.execrise.controller;

import com.example.execrise.model.Product;
import com.example.execrise.service.ICartService;
import com.example.execrise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes
public class ProductRepository {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICartService cartService;

    @ModelAttribute ("/cart")
    public Map<Product, Integer> createCart(){
        return new HashMap<>();
    }

    @GetMapping("")
    public String showShop(Model model){
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/detail")
    public String goDetal(@RequestParam Long id, Model model){
            model.addAttribute("products", productService.findById(id));
            return "detail";
    }

    @GetMapping("/add")
    public String addProduct(@RequestParam Long id,
                             @SessionAttribute("cart") Map<Product, Integer> cart) {

        Product product = this.productService.findById(id);
        cartService.addProduct(cart, product);

        return "redirect:";
    }

    @GetMapping("/cart")
    public String goCart(Model model, @SessionAttribute("cart") Map<Product, Integer> cart) {
        double total = cartService.getTotal(cart);
        model.addAttribute("cart",cart);
        model.addAttribute("total",total);
        return "cart";
    }

}
