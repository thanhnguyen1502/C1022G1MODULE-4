package com.example.execrise.repository;

import com.example.execrise.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IBlogRepository extends JpaRepository <Blog, Integer>{

}
