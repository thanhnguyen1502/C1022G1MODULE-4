package com.example.book_management.controller;

import com.example.book_management.model.Book;
import com.example.book_management.model.BookCard;
import com.example.book_management.service.IBookCardService;
import com.example.book_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LibraryController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IBookCardService bookCardService;

    @GetMapping(value = {"", "/list"})
    public String goHome(Model model){
        model.addAttribute("books", bookService.findAll());
        return "index";
    }

    @GetMapping("/details")
    public String showDetailsBook(@RequestParam int id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        model.addAttribute("bookcard", new BookCard(book));
        return "details";
    }

    @GetMapping("rent")
    public String rent(Model model){
        return "";
    }
    @PostMapping("/rent")
    public String rentBook(@ModelAttribute(name = "bookcard") BookCard bookCard,
                           RedirectAttributes redirectAttributes) {
        Book book = bookService.findById(bookCard.getBook().getId());
        book.getAmount(book.getAmount()-1);
        bookService.save(book);
        bookCardService.save(bookCard);
        redirectAttributes.addFlashAttribute("message", "Đã thuê sách: " + book.getName());
        return "redirect:/list";
    }

    @GetMapping("/pay")
    public String payBook(@RequestParam int id,
                          RedirectAttributes redirectAttributes) throws Exception {
        BookCard bookCard = bookCardService.getById(id);
        if(bookCard == null) {
            throw new Exception();
        }
        Book book = bookCard.getBook();
        book.setAmount(book.getAmount() + 1);
        bookCardService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Đã trả sách");
        return "redirect:/list";
    }

    @ExceptionHandler(value = Exception.class)
    public String goError() {
        return "error404";
    }
}
