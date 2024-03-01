package com.example.d5ex2employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.d5ex2employee.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    
}
