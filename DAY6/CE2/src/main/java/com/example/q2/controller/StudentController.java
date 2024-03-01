package com.example.q2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.q2.model.Student;
import com.example.q2.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class StudentController {
    @Autowired
    StudentService obj;
    @PostMapping("/api/student")
    public ResponseEntity<Student> postMethodName(@RequestBody Student entity) {
      
        
        return new ResponseEntity<>(obj.postStudent(entity),HttpStatus.CREATED);
    }
    @GetMapping("/api/student")
    public ResponseEntity<List<Student>> getMethodName(@RequestParam int pagetNo,@RequestParam int pageSize) {
        return new ResponseEntity<>(obj.Paging(pagetNo, pageSize),HttpStatus.OK);
    }
    @GetMapping("/api/student/sort")
    public ResponseEntity<List<Student>> getMethodName(@RequestParam int pageNo,@RequestParam int pageSize,@RequestParam String SortBy) {
        return new ResponseEntity<>(obj.PagingAndSorting(pageNo, pageSize, SortBy),HttpStatus.OK);
    }
    
    
    
}
