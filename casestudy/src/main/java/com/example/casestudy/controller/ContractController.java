package com.example.casestudy.controller;

import com.example.casestudy.dto.contract.ContractDto;
import com.example.casestudy.service.contract.IAttachFacilityService;
import com.example.casestudy.service.contract.IContractDetailService;
import com.example.casestudy.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

//    @GetMapping("home")
//    public String showContractList(Model model, @PageableDefault(value = 3)Pageable pageable,
//                                   @RequestParam(value = "nameContract",defaultValue = "") String nameContract){
//        model.addAttribute("contract", contractService.findAll(pageable));
//        model.addAttribute("nameContract", nameContract);
//        return "contract-list";
//    }

    @GetMapping("/home")
    public String goHome(@PageableDefault(size = 3)Pageable pageable,
                         @RequestParam Optional<String> keySearch,
                         Model model){

        String keyVal = keySearch.orElse("");

        model.addAttribute("contract",
                this.contractService.findAll(pageable));

        model.addAttribute("attachFacilityList",
                this.attachFacilityService.findAll());

        return "contract-list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("attachFacility", attachFacilityService.findAll());
        return "contract-list";
    }
    @PostMapping("/save")
    public String goCreateForm(@ModelAttribute @Valid ContractDto contractDto,
                               Model model,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            model.addAttribute("contract", contractService.findAll(Pageable.unpaged()));
        }
        return "contract-list";
//        Contract contract = new Contract();
//        BeanUtils.copyProperties(contractDto, contract);
    }
}
