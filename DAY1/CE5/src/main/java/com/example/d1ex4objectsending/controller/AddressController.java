package com.example.d1ex4objectsending.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.d1ex4objectsending.module.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class AddressController {
    List<Student> a = new ArrayList<>();
    @GetMapping("/student")
    public List<Student> f1()
    {
       Student obj=new Student("Aishu", "IT");
       a.add(obj);
       Student obj1=new Student("ram", "CSE");
       a.add(obj1);
        return a;
    }
    
}
