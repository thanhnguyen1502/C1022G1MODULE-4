package com.example.casestudy.controller;

import com.example.casestudy.service.ICustomerService;
import com.example.casestudy.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Repository
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/home")
    public String goCustomerList(Model model, @PageableDefault(value = 3)Pageable pageable, @RequestParam Optional<String> keysearch){
        String keyval = keysearch.orElse("");
        model.addAttribute("customer", this.customerService.findAllByNameContaining(keyval, pageable));
        model.addAttribute("keySearch", keyval);
        return "customer-list";
    }
    @GetMapping("/list")
    public String goCustomerUsingServie(@PageableDefault(size = 3) Pageable pageable,
                                        @RequestParam Optional<String> keySearch,
                                        Model model) {

        String keyVal = keySearch.orElse("");

        String now = String.valueOf(LocalDate.now());

        model.addAttribute("contracts",
                this.customerService.findAllByContracts_EndDateBefore(now, pageable));

        model.addAttribute("keySearch", keyVal);

        return "customer-has-contract";
    }
}
