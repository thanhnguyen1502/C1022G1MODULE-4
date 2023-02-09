package com.example.form.controller;

import com.example.form.dto.UserDto;
import com.example.form.model.User;
import com.example.form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String findAll(Model model){
        model.addAttribute("userList",userService.findAll());
        return "list";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute UserDto userDto,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirects){
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("userDto", userDto);
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.add(user);
        redirects.addFlashAttribute("mess","add ok");
        return "redirect:/";
    }

    @GetMapping("create")
    public String showCreateForm(Model model){
        model.addAttribute("validateList", new UserDto());
        return "create";
    }
}
