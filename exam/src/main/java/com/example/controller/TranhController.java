package com.example.controller;

import com.example.dto.TranhDto;
import com.example.model.Tranh;
import com.example.service.ITheLoaiService;
import com.example.service.ITranhService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tranh")
public class TranhController {
    @Autowired
    private ITranhService tranhService;

    @Autowired
    private ITheLoaiService theLoaiService;

    @GetMapping("/home")
    public String goHome(Model model, @RequestParam(value = "timTacPham", defaultValue = "") String timTacPham){
        model.addAttribute("dsTranh", tranhService.findAllByName(timTacPham));
        model.addAttribute("dsTheLoai", theLoaiService.findAll());
        model.addAttribute("timTacPham", timTacPham);
        return "list";
    }

    @GetMapping("delete")
    public String delete( @RequestParam Integer id){
        tranhService.remove(id);
        return "redirect:/tranh/home";
    }

    @GetMapping("/create")
    public String showListCreate(Model model){
        model.addAttribute("tranhDto", new TranhDto());
        model.addAttribute("dsTheLoai", theLoaiService.findAll());
        return "create";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute TranhDto tranhDto,
                      BindingResult bindingResult, Model model,
                      RedirectAttributes redirectAttributes){
        new TranhDto().validate(tranhDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("dsTheLoai", theLoaiService.findAll());
            return  "create";
        }
        Tranh tranh = new Tranh();
        BeanUtils.copyProperties(tranhDto, tranh);
        tranhService.save(tranh);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công! ");
        return "redirect:/tranh/home";
    }
}
