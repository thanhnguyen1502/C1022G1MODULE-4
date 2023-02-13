package com.example.book_management.service;

import com.example.book_management.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Integer id);
    void save(Book book);
}
