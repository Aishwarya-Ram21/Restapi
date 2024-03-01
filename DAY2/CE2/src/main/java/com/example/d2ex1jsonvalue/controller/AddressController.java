package com.example.d2ex1jsonvalue.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.d2ex1jsonvalue.module.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AddressController {
    @Autowired
    Address obj;
    @GetMapping("/path")
    public String getMethodName() {
        return (obj.property+" "+obj.abi);
    }
    
}
