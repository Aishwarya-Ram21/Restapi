package com.example.d7ex2.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.d7ex2.model.Course;

public interface CourseRepo extends JpaRepository<Course,Integer> {
    @Modifying
    @Query("insert into Course(courseId,courseName,creditHours,instructor,preRequisites,maxCapacity,enrolledStudents) values (?1,?2,?3,?4,?5,?6,?7)")
    void saveCourse(int courseId,String courseName,int i, String instructor,String preRequisites,int maxCapacity,String enrolledStudents);

    @Query("Select a from Course a")
    List<Course>findAllCourses();

    @Query("select a from Course a where a.courseName=?1")
    List<Course> findByCourseName(String courseName);

    Optional<Course>findByCourseId(int courseId);
}
