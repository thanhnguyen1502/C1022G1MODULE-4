package com.example.book_management.repository;

import com.example.book_management.model.BookCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookCardRepository extends JpaRepository<BookCard, Integer> {
}
