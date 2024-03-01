package com.example.d7ex1.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.d7ex1.model.Person;
import com.example.d7ex1.repo.PersonRepo;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class PersonService {
    @Autowired
    PersonRepo repo;

    public void saveUser(Person person) 
    {
        Optional<Person> personExists=repo.findByFirstName(person.getFirstName());
        if(personExists.isPresent())
        {
            return;
        }
        repo.saveUser(person.getFirstName(),person.getLastName(),person.getAge(),person.getGender());
    }
    public List<Person> getAllPerson()
    {
        if(repo.count()<0)
        {
            return java.util.Collections.emptyList();
        }
        return repo.findAllPerson();
    }
    public List<Person> getAllPersonsByAge(int age)
    {
        if(repo.count()<0)
        {
            return java.util.Collections.emptyList();
        }
        return repo.findPersonByAge(age);
    }
}
