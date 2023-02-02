package com.example.repository.impl;


import com.example.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static List<String> languageList = new ArrayList<>();
    private static List<Integer> pageList = new ArrayList<>();

    static {
        languageList.add("English");
        languageList.add("VietNam");
        languageList.add("Japan");
        languageList.add("Korea");
    }

    static {
        pageList.add(5);
        pageList.add(10);
        pageList.add(15);
        pageList.add(20);
        pageList.add(25);
        pageList.add(30);
    }
    @Override
    public List<String> showLanguage() {
        return languageList;
    }

    @Override
    public List<Integer> showPage() {
        return pageList;
    }
}
