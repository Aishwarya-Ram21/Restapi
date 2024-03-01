package com.example.d7ex2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.d7ex2.model.Course;
import com.example.d7ex2.repo.CourseRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseService {
    @Autowired
    CourseRepo repo;

    public void saveCourse(Course course)
    {
        Optional<Course> courseExists=repo.findByCourseId(course.getCourseId());
        if(courseExists.isPresent())
        {
            return;
        }
        repo.saveCourse(course.getCourseId(),course.getCourseName(),course.getCreditHours(),course.getInstructor(),course.getPreRequisites(),course.getMaxCapacity(),course.getEnrolledStudents());
    }

    public List<Course> getAllCourses()
    {
        if(repo.count()<0)
        {
            return java.util.Collections.emptyList();
        }
        return repo.findAllCourses();
    }

    public List<Course> getAllCoursesByName(String courseName)
    {
        if(repo.count()<0)
        {
            return java.util.Collections.emptyList();
        }
        return repo.findByCourseName(courseName);
    }
}
