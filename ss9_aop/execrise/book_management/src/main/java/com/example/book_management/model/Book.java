package com.example.book_management.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    private int id;
    private String name;
    private String summary;
    private int amount;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookCard> bookCards;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<BookCard> getBookCards() {
        return bookCards;
    }

    public void setBookCards(List<BookCard> bookCards) {
        this.bookCards = bookCards;
    }

    public void getAmount(Object o) {
    }
}
