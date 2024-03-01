package com.example.d7ex1.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.example.d7ex1.model.Person;

public interface PersonRepo extends JpaRepository<Person,Integer>{
    @Modifying
    @Query("insert into Person(firstName,lastName,age,gender) values(?1,?2,?3,?4)")
    void saveUser(String firstName,String lastName,int age,String gender);
    
    @Query("select a from Person a")
    List<Person>findAllPerson();

    @Query("select a from Person a where a.age=?1")
    List<Person> findPersonByAge(int age);

    Optional<Person>findByFirstName(String fname);
}
