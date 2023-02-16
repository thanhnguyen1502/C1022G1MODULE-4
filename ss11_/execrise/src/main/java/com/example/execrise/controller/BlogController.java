package com.example.execrise.controller;

import com.example.execrise.model.Blog;
import com.example.execrise.service.IBlogService;
import com.example.execrise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = {"", "/list"})
    public String goHomePage(@RequestParam(defaultValue = "") String keyword, Model model,
                             @RequestParam(defaultValue = "") String categoryName,
                             @PageableDefault(size = 3) Pageable pageable) {
        model.addAttribute("categories", this.iCategoryService.findAllCategory());
        model.addAttribute("keyword", keyword);
        model.addAttribute("categoryName", categoryName);
        model.addAttribute("blogList", this.iBlogService.findAll(keyword, categoryName, pageable));
        return "index";
    }

    @GetMapping("/write")
    public String showFormBlog(Model model) {
        model.addAttribute("categories", this.iCategoryService.findAllCategory());
        model.addAttribute("blog", new Blog());
        return "create-blog";
    }

    @PostMapping("/save")
    public String saveNewBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Tiến trình thành công");
        return "redirect:";
    }

    @GetMapping("/update")
    public String showFormEdit(@RequestParam int id, Model model) {
        model.addAttribute("categories", this.iCategoryService.findAllCategory());
        model.addAttribute("blog", this.iBlogService.findBlogById(id));
        return "edit-blog";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.saveBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:";
    }

    @GetMapping("/details")
    public String showDetailsBlog(@RequestParam int id, Model model) {
        model.addAttribute("blog", this.iBlogService.findBlogById(id));
        return "view-blog";
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        this.iBlogService.deleteBlogById(idDelete);
        redirectAttributes.addFlashAttribute("message", "Đã xoá");
        return "redirect:";
    }
}