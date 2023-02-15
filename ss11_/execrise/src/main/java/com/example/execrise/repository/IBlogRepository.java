package com.example.execrise.repository;

import com.example.execrise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByTitleContainingAndCategory_CategoryNameContaining(String keyword, String categoryName, Pageable pageable);

    List<Blog> findAllByCategory_Id(int id);
}
