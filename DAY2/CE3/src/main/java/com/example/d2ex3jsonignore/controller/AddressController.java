package com.example.d2ex3jsonignore.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.d2ex3jsonignore.module.Address;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AddressController {
    @GetMapping("/abi")
    public Address getMethodName() {
        Address obj=new Address("abi", 12);
        return obj;
    }
    
}
