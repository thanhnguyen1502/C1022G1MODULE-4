package com.example.execrise.repository;

import com.example.execrise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository <Blog, Integer>{
//phân trang
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
}