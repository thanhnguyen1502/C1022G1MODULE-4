package com.example.execrise.repository;

import com.example.execrise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByTitleContainingAndCategory_CategoryNameContaining(String title, String categoryName,
                                                                          Pageable pageable);

    List<Blog> findAllByCategory_Id(int id);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
