package com.example.d1ex4arraylistofobjectsending.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.d1ex4arraylistofobjectsending.module.Address;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class AddressController {
    @GetMapping("/address")
    public ArrayList<Address> f1()
    {
         ArrayList<Address> d=new ArrayList<Address>();
         Address l=new Address("aishu",38,"new street",60085,"pudukkottai","TN","INDIA","East main");
         d.add(l);
         return d;
    }
    
}
