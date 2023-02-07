package com.example.execrise.service.impl;

import com.example.execrise.model.Blog;
import com.example.execrise.repository.IBlogRepository;
import com.example.execrise.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> finAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void saveBlog(Blog blog) {
    iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.getById(id);
    }

    @Override
    public void deleteBlog(int id) {
    iBlogRepository.deleteById(id);
    }
}
