package com.example.service.impl;

import com.example.service.ICaculationService;
import org.springframework.stereotype.Service;

@Service
public class CaculationService implements ICaculationService {

    @Override
    public String result(String number1, String number2, String condition) {
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        double result = 0;
        switch (condition) {
            case "addition":
                result = num1 + num2;
                break;
            case "suptraction":
                result = num1 - num2;
                break;
            case "mutiplication":
                result = num1 * num2;
                break;
            case "divition":
                result = num1 / num2;
                break;
        }
        return String.valueOf(result);
    }
}
