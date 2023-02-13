package com.example.book_management.service;

import com.example.book_management.model.BookCard;

public interface IBookCardService {
    void save(BookCard bookCard);
    void deleteById(int id);
    BookCard getById(int id);
}
