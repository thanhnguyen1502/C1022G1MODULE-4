package com.example.book_management.service.impl;

import com.example.book_management.model.BookCard;
import com.example.book_management.repository.IBookCardRepository;
import com.example.book_management.service.IBookCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCardService implements IBookCardService {
    @Autowired
    private IBookCardRepository bookCardRepository;

    @Override
    public void save(BookCard bookCard) {
        bookCardRepository.save(bookCard);
    }

    @Override
    public void deleteById(int id) {
        bookCardRepository.deleteById(id);
    }

    @Override
    public BookCard getById(int id) {
        return bookCardRepository.getById(id);
    }

}
