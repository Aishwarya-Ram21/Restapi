package com.example.d7ex3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.d7ex3.model.Door;
import com.example.d7ex3.repo.DoorRepo;

@Service
public class DoorService {

    @Autowired
    DoorRepo doorRepo;

    public Door getdoor(Door door) {
        return doorRepo.save(door);
    }
    public List<Door> findDoor() {
        return doorRepo.findAll();
    }
    public List<Door> findBydoorId(int doorId) {
        return doorRepo.findBydoorId(doorId);
    }

    public List<Door> findByaccessType(String accessType) {
        return doorRepo.findByaccessType(accessType);
    }
    
}