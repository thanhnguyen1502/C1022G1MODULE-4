package com.example.form.service;

import com.example.form.model.User;

import java.util.List;

public interface IUserService {
    void add(User user);
    List<User> findAll();
}
