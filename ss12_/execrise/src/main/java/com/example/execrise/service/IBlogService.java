package com.example.execrise.service;

import com.example.execrise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAll(String keyword, String categoryName, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findBlogById(int id);

    void saveBlog(Blog blog);

    void deleteBlogById(int id);

    List<Blog> findAllBlogByCategoryId(int id);

    Page<Blog> findAllByTitle(String title, Pageable pageable);
}
