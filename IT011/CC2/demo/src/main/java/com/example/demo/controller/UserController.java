package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Grocery;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController
{
   @Autowired
   UserService groceryservice;


   @PostMapping("/user")
   public ResponseEntity<User> adduser(@RequestBody User obj) {
      
      try {
          
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(groceryservice.adduser(obj));
        } catch (Exception e) {
           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(groceryservice.adduser(obj));
        }
   }
    
   @GetMapping("/user")
   public List<User> allusers() {
       return groceryservice.allusers();
   }

   @GetMapping("/user/{userid}")
   public Optional<User> getuserbyid(@PathVariable Long userid) {
       return groceryservice.getuserbyid(userid);
   }

   @PutMapping("/user/{userid}")
   public User edituser(@PathVariable Long userid, @RequestBody User obj) {
      
    return groceryservice.edituser(userid, obj);
   }
   
   @DeleteMapping("/user/{userid}")
   public void deleteuser(@PathVariable Long userid)
   {
    groceryservice.deleteuser(userid);
   }



   @GetMapping("/item")
   public List<Grocery> allitems() {
    return groceryservice.allitems();
   }
   
   
   @GetMapping("user/get/page/{no}/{size}")
   public List<User> getMethodbyPage(@PathVariable int no,@PathVariable int size)
   {
       return groceryservice.getByPaging(no, size);
   }
   @GetMapping("user/get/pageandsort/{field}/{no}/{size}")
   public List<User> getMethodbySortandPage(@PathVariable String field,@PathVariable int no,@PathVariable int size)
   {
       return groceryservice.getBySortandPages(field,no,size);
   }
    
   @GetMapping("user/get/sort/{field}")
    public List<User> getMethodbySort(@PathVariable String field)
    {
        return groceryservice.getBySortedbyName(field);
    }

}
   

