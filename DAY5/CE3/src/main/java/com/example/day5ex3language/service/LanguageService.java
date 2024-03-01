package com.example.day5ex3language.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day5ex3language.model.Language;
import com.example.day5ex3language.repo.LanguageRepo;

@Service
public class LanguageService {
    @Autowired
    LanguageRepo languageRepo;

    public Language add(Language language)
    {
        return languageRepo.save(language);
    }

    public List<Language> get()
    {
        return languageRepo.findAll();
    }

    public Optional<Language> getId(int id)
    {
        return languageRepo.findById(id);
    }

    public Language edit(int id,Language language)
    {
        Language la=languageRepo.findById(id).orElse(null);
        if(la!=null)
        {
            la.setLanguageName(language.getLanguageName());
            la.setLanguageComplexity(language.getLanguageComplexity());
            return languageRepo.saveAndFlush(la);
        }
        else 
        return null;
    }

    public String delete(int id)
    {
        languageRepo.deleteById(id);
        return ("deleted");
    }
}
