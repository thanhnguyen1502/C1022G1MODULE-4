package com.example.service.impl;

import com.example.service.ICurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {

    @Override
    public double convert(double usd, double rate) {
        return rate * usd;
    }
}
