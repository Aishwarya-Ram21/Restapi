package com.example.d4ex1jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.d4ex1jpa.model.Medicine;

@Repository
public interface MedicineRepo extends JpaRepository<Medicine,Long>{
    
}
