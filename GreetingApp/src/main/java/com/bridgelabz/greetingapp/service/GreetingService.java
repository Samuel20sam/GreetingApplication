package com.bridgelabz.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getmessage() {
        return "Hello World This is Samuel from Service layer";
    }
}
