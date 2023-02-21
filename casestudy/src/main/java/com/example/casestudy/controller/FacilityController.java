package com.example.casestudy.controller;

import com.example.casestudy.dto.facility.FacilityDto;
import com.example.casestudy.model.facility.Facility;
import com.example.casestudy.model.facility.FacilityType;
import com.example.casestudy.model.facility.RentType;
import com.example.casestudy.service.facility.IFacilityService;
import com.example.casestudy.service.facility.IFacilityTypeService;
import com.example.casestudy.service.facility.IRentTypeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Repository
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/home")
    public String goFacilityList(Model model, @PageableDefault(value = 3)Pageable pageable,
                                 @RequestParam(value = "nameFacility", defaultValue = "") String nameFacility){
        model.addAttribute("facility", facilityService.findAllByNameContaining(nameFacility,pageable));
        model.addAttribute("nameFacility", nameFacility);
        return "facility-list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility-create";
    }

    @GetMapping("/save")
    public String goCreateForm(@ModelAttribute @Valid FacilityDto facilityDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model){
//        new FacilityDto().validate(facilityDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("facilityTypeList",
                    this.facilityTypeService.findAll());

            model.addAttribute("rentTypeList",
                    this.rentTypeService.findAll());

            return "facility-create";
        }

        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);

        FacilityType facilityType = new FacilityType();
        facilityType.setId(facilityDto.getFacilityType().getId());
        facilityDto.setFacilityType(facilityType);

        RentType rentType = new RentType();
        rentType.setId(facilityDto.getRentType().getId());
        facilityDto.setRentType(rentType);

        this.facilityService.save(facility);

        redirectAttributes.addFlashAttribute("message",
                "successfully added new");

        return "redirect:/facility/home";
    }
}
