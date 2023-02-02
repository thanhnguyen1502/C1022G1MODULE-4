package com.example.service.impl;

import com.example.repository.IEmailRepository;
import com.example.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    IEmailRepository emailRepository;


    @Override
    public List<String> showLanguage() {
        return emailRepository.showLanguage();
    }

    @Override
    public List<Integer> showPage() {
        return emailRepository.showPage();
    }
}
