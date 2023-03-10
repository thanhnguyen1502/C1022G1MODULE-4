package com.example.casestudy.controller;

import com.example.casestudy.dto.customer.CustomerDto;
import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.customer.CustomerType;
import com.example.casestudy.service.customer.ICustomerService;
import com.example.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Repository
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

//    @GetMapping("/home")
//    public String goCustomerList(Model model, @PageableDefault(value = 3)Pageable pageable,
//                                 @RequestParam(value = "nameCustomer", defaultValue = " ") String nameCustomer)
//    {
//        model.addAttribute("customer",customerService.findAllByNameContaining(nameCustomer, pageable));
//        model.addAttribute("nameCustomer", nameCustomer);
//        return "customer-list";
//    }

    @GetMapping("/home")
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                           @RequestParam(value = "emailSearch", defaultValue = "") String emailSearch,
                           @RequestParam(value = "customerType", defaultValue = "0") Integer customerType,
                           Model model) {

        if (customerType == 0) {
            model.addAttribute("customer", customerService.searchCustomer(nameSearch, emailSearch
                    , pageable));
        } else {
            model.addAttribute("customer", customerService.searchCustomerType(nameSearch,
                    emailSearch, customerType, pageable));
        }
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("addressSearch", emailSearch);
        model.addAttribute("customerType", customerType);

        return "customer-list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", this.customerTypeService.findAll());

        return "customer-create";
    }

    @GetMapping("/save")
    public String goCreateForm(Model model) {

        model.addAttribute("customerDto", new CustomerDto());

        model.addAttribute("customerTypeList",
                this.customerTypeService.findAll());

        return "customer-create";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute @Valid CustomerDto customerDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {

        new CustomerDto().validate(customerDto, bindingResult);

        if (bindingResult.hasErrors()){
            model.addAttribute("customerTypeList",
                    this.customerTypeService.findAll());
            return "customer-create";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        //thay ?????i id c???a b???ng ph???
        CustomerType customerType = new CustomerType();
        customerType.setId(customerDto.getCustomerType().getId());
        customer.setCustomerType(customerType);

        this.customerService.save(customer);

        redirectAttributes.addFlashAttribute("message",
                "successfully added new");

        return "redirect:/customer/home";
    }

}
