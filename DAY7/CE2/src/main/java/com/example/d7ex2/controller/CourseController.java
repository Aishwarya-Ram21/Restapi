package com.example.d7ex2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.d7ex2.model.Course;
import com.example.d7ex2.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping
    public ResponseEntity<?> saveCourse(@RequestBody Course course)
    {
        try{
            courseService.saveCourse(course);
            return new ResponseEntity<>(course,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping
    public ResponseEntity<?> getCourse()
    {
        try{
            return ResponseEntity.status(200).body(courseService.getAllCourses());
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping("/byCourse/{course}")
    public ResponseEntity<?> getAllCoursesByName(@PathVariable("course") String course)
    {
        try{
            return ResponseEntity.status(200).body(courseService.getAllCoursesByName(course));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }
}
