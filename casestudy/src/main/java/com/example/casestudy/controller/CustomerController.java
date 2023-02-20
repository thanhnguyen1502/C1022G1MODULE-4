package com.example.casestudy.controller;

import com.example.casestudy.dto.customer.CustomerDto;
import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.customer.CustomerType;
import com.example.casestudy.service.ICustomerService;
import com.example.casestudy.service.ICustomerTypeService;
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
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerType", this.customerTypeService.findAll());
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

        //thay đổi id của bảng phụ
        CustomerType customerType = new CustomerType();
        customerType.setId(customerDto.getCustomerType().getId());
        customer.setCustomerType(customerType);

        this.customerService.save(customer);

        redirectAttributes.addFlashAttribute("message",
                "successfully added new");

        return "redirect:/customer/home";
    }
}
