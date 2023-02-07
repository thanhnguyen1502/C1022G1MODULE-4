package com.example.execrise.controller;

import com.example.execrise.model.Blog;
import com.example.execrise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/blog")
    public String goHome(Model model){
        model.addAttribute("blogs", blogService.finAll());
        return "blog-home";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog", new Blog());
        return "blog-create";

    }

    @GetMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.saveBlog(blog);

        return "blog-edit";
    }

    @GetMapping("/read")
    public String goReadPage(@RequestParam int id, Model model){

        model.addAttribute("blog",
                this.blogService.findById(id));

        return "blog-read";
    }

    @GetMapping("/edit")
    public String goEditForm(@RequestParam int id, Model model){

        model.addAttribute("blog",
                this.blogService.findById(id));

        return "/blog-edit";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam int senId){

        this.blogService.deleteBlog(senId);

        return "redirect:/blog";
    }
}
