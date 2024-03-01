package com.example.d7ex1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.d7ex1.model.Person;
import com.example.d7ex1.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired 
    PersonService personService;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody Person person)
    {
        try{
            personService.saveUser(person);
            return new ResponseEntity<>(person,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping
    public ResponseEntity<?> getPersons()
    {
        try{
            
            return ResponseEntity.status(200).body(personService.getAllPerson());
        }
        catch(Exception e)
        {
            
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping("/byAge/{age}")
    public ResponseEntity<?> getAllPersonsByAge(@PathVariable("age") int age)
    {
        try{
            
            return ResponseEntity.status(200).body(personService.getAllPersonsByAge(age));
        }
        catch(Exception e)
        {
            return ResponseEntity.status(500).build();
        }
    }
    
    


    
    
}
