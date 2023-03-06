package com.example.test.controller;

import com.example.test.dto.CustomerDto;
import com.example.test.model.Customer;
import com.example.test.model.CustomerType;
import com.example.test.service.ICustomerService;
import com.example.test.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/home")
    public String goHome(Model model, @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch) {
        model.addAttribute("customer", customerService.findByname(nameSearch));
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("customerType", customerTypeService.findAll());
        return "customer-list";
    }

    @PostMapping("/delete")
    public String remove(@RequestParam Integer id) {
        customerService.remove(id);
        return "redirect:/customer/home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerType", customerTypeService.findAll());
        return "customer-create";
    }

    @PostMapping("/add")
    public String saveCreate(@Validated @ModelAttribute CustomerDto customerDto,
                             BindingResult bindingResult, Model model,
                             RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "customer-create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "ok");
        return "redirect:/customer/home";
    }

    @GetMapping("/edit/{id}")
    public String showUpdate(Model model, @PathVariable Integer id) {
        Customer customer = customerService.findById(id);

        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);

        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerType", customerTypeService.findAll());
        return "customer-edit";
    }

    @PostMapping("/save")
    public String updateCreate(@Validated @ModelAttribute CustomerDto customerDto,
                               BindingResult bindingResult, Model model,
                               RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", customerTypeService.findAll());
            return "customer-edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "ok");
        return "redirect:/customer/home";
    }
}
