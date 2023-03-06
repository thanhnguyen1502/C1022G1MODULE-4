package com.example.test2.controller;

import com.example.test2.dto.StudentDto;
import com.example.test2.model.Student;
import com.example.test2.service.IScheduleTypeService;
import com.example.test2.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IScheduleTypeService scheduleTypeService;

    @GetMapping("/home")
    public String goHome(Model model, @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch) {
        model.addAttribute("students", studentService.findAllByName(nameSearch));
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("schedule", scheduleTypeService.findAll());
        return "student-list";
    }

    @GetMapping("/create")
    public String showListAdd(Model model) {
        model.addAttribute("studentDto", new StudentDto());
        model.addAttribute("scheduleType", scheduleTypeService.findAll());
        return "student-create";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute StudentDto studentDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes,
                      Model model
    ) {
        new StudentDto().validate(studentDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("scheduleType", scheduleTypeService.findAll());
            return "student-create";
        }

        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        redirectAttributes.addFlashAttribute("mess", "ok");
        return "redirect:/student/home";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {
        studentService.remove(id);
        return "redirect:/student/home";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(Model model, @PathVariable Integer id) {
        Student student = studentService.findById(id);
        StudentDto studentDto = new StudentDto();

        BeanUtils.copyProperties(student, studentDto);

        model.addAttribute("studentDto", studentDto);
        model.addAttribute("scheduleType", scheduleTypeService.findAll());
        return "student-edit";
    }

    @PostMapping("/save")
    public String save(
            @Validated StudentDto studentDto, BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {
        new StudentDto().validate(studentDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("scheduleType", scheduleTypeService.findAll());
            return "student-edit";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        redirectAttributes.addFlashAttribute("mess", "ok");
        return "redirect:/student/home";
    }
}
