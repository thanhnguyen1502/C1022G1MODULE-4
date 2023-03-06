package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.Customer;
import com.example.service.ICustomerService;
import com.example.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/home")
    public String goHome(Model model, @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch) {
        model.addAttribute("customerList", customerService.findAllByName(nameSearch));
        model.addAttribute("customerType", customerTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);

        return "customer-list";
    }

    @GetMapping("/delete")
    public String remove(@RequestParam Integer id) {
        customerService.remove(id);
        return "redirect:/customer/home";
    }

    @GetMapping("/create")
    public String showListCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer-create";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute CustomerDto customerDto,
                      BindingResult bindingResult, Model model,
                      RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer-create";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công !!!");
        return "redirect:/customer/home";
    }
}
