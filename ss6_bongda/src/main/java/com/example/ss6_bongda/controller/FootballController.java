package com.example.ss6_bongda.controller;

import com.example.ss6_bongda.dto.FootballDto;
import com.example.ss6_bongda.model.Football;
import com.example.ss6_bongda.service.IFootballService;
import com.example.ss6_bongda.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class FootballController {
    @Autowired
    private IFootballService footballService;

    @Autowired
    private ITeamService teamService;

    @GetMapping("/home")
    private String goHome(Model model,@RequestParam(value = "name", defaultValue = "") String keySearch){
        model.addAttribute("footballList", footballService.findAllByNameAllBirthday(keySearch));
        model.addAttribute("teamList", teamService.findAll());
        model.addAttribute("name", keySearch);
        return "football-list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        footballService.remove(id);
        return "redirect:/home";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("footballDto", new FootballDto());
        model.addAttribute("teamList", teamService.findAll());
        return "football-create";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute FootballDto footballDto,
                      BindingResult bindingResult, Model model,
                      RedirectAttributes redirectAttributes){
        new FootballDto().validate(footballDto, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("teamList", teamService.findAll());
            return "football-list";
        }
        Football football = new Football();
        BeanUtils.copyProperties(footballDto, football);
        footballService.save(football);
        redirectAttributes.addFlashAttribute("mess", "successfully added new! ");
        return "redirect:/home";
    }
}
