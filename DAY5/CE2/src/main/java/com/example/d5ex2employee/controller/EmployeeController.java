package com.example.d5ex2employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.d5ex2employee.model.Employee;
import com.example.d5ex2employee.service.EmployeeService;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee)
    {
        return employeeService.add(employee);
    }

    @GetMapping("/get")
    public List<Employee> get()
    {
        return employeeService.get();
    }

    @PutMapping("/edit/{id}")
    public Employee get(@PathVariable int id,@RequestBody Employee employee)
    {
        return employeeService.edit(id,employee);
    }

    @DeleteMapping("/del/{id}")
    public String del(@PathVariable int id)
    {
        return employeeService.delete(id);
    }
}
