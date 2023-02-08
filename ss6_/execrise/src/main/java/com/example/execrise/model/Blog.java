package com.example.execrise.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String author;

    @ManyToOne
    @JoinColumn(name = "catelogy_id",referencedColumnName = "id")
    private Catelory catelory;
    @Column(columnDefinition = "")
    private String content;

    public Blog() {
    }

    public Catelory getCatelory() {
        return catelory;
    }

    public void setCatelory(Catelory catelory) {
        this.catelory = catelory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
