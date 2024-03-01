package com.example.day5ex3language.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.day5ex3language.model.Language;
import com.example.day5ex3language.service.LanguageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @PostMapping("/add")
    public Language postMethodName(@RequestBody Language language) {
        return languageService.add(language);
    }

    @GetMapping("/get")
    public List<Language> get() {
        return languageService.get();
    }

    @GetMapping("/get/{id}")
    public Optional<Language> getId(@PathVariable int id) {
        return languageService.getId(id);
    }
    
    @PutMapping("/edit/{id}")
    public Language edit(@PathVariable int id, @RequestBody Language language) {
        return languageService.edit(id,language);
    }

    @DeleteMapping("/del/{id}")
    public String del(@PathVariable int id)
    {
        return languageService.delete(id);
    }
    
}
