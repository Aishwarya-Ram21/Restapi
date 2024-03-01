package com.example.d2ex4jsonformat.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.d2ex4jsonformat.module.Address;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AddressController {
    Date d=new Date();
    @GetMapping("/abi")
    public Address f1()
    {
        Address obj=new Address("ji", "hi", d);
        return obj;
    }
    
    
}
