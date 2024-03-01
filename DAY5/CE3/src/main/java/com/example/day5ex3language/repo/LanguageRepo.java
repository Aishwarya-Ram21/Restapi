package com.example.day5ex3language.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day5ex3language.model.Language;

@Repository
public interface LanguageRepo extends JpaRepository<Language,Integer> {
    
}
