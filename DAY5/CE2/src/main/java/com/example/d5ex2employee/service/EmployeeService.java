package com.example.d5ex2employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.d5ex2employee.model.Employee;
import com.example.d5ex2employee.repo.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public Employee add(Employee employee)
    {
         return employeeRepo.save(employee);
    }

    public List<Employee> get()
    {
        return employeeRepo.findAll();
    }

    public String delete(int id)
    {
        employeeRepo.deleteById(id);
        return ("deleted");
    }

    public Employee edit(int id,Employee employee)
    {
        Employee ea=employeeRepo.findById(id).orElse(null);
        if(ea!=null)
        {
            ea.setEmployeeName(employee.getEmployeeName());
            ea.setEmployeeEmail(employee.getEmployeeEmail());
            ea.setSalary(employee.getSalary());
            ea.setDepartment(employee.getDepartment());
            return employeeRepo.saveAndFlush(ea);
        }
        else 
        return null;
    }
}
