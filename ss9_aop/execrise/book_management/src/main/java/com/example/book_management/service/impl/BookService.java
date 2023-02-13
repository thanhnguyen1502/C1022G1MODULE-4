package com.example.book_management.service.impl;

import com.example.book_management.model.Book;
import com.example.book_management.repository.IBookRepository;
import com.example.book_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(new Book());
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }
}
