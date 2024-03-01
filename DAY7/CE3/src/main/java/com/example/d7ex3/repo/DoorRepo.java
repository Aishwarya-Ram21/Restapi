package com.example.d7ex3.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.d7ex3.model.Door;

@Repository
public interface DoorRepo extends JpaRepository<Door,Integer> {
    
    List<Door> findBydoorId(int doorId);

    List<Door> findByaccessType(String accessType);
}