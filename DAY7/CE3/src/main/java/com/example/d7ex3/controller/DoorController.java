package com.example.d7ex3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.d7ex3.model.Door;
import com.example.d7ex3.service.DoorService;

@RestController
public class DoorController {

    @Autowired
    DoorService doorService;

    @PostMapping("/api/door")
    public ResponseEntity<Door> getdoor(@RequestBody Door door) {
       
        Door d=doorService.getdoor(door);
        if(d!=null)
        {
            return new ResponseEntity<Door>(d,HttpStatus.CREATED);
        }
        else
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    } 

    @GetMapping("/api/door")
    public ResponseEntity<List<Door>> findDoor() {
          List<Door> d=doorService.findDoor();
        if(d!=null)
        {
            return new ResponseEntity<List<Door>> (d,HttpStatus.OK);
        }
        else
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

          
    }

    @GetMapping("/api/door/{doorId}")
    public ResponseEntity<List<Door>> findBydoorId(@PathVariable int doorId ) {
       List<Door> d=doorService.findBydoorId(doorId);
       if(d!=null)
       {
           return new ResponseEntity<List<Door>> (d,HttpStatus.OK);
       }
       else
       return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/door/accesstype/{accessType}")
    public ResponseEntity<List<Door>> findByaccessType(@PathVariable String accessType ) {
      List<Door> d=doorService.findByaccessType(accessType);
      if(d!=null)
      {
          return new ResponseEntity<List<Door>> (d,HttpStatus.OK);
      }
      else
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}