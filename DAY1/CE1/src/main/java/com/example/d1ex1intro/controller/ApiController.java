package com.example.d1ex1intro.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ApiController {
    @GetMapping("/welcome")
    public String getMethodName() {
        return ("HELLO!");
    }
    
}
