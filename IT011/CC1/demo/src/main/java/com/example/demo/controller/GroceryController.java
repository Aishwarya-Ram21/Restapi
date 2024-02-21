package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Grocery;
import com.example.demo.model.User;
import com.example.demo.service.GroceryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class GroceryController
{
   @Autowired
   GroceryService groceryservice;


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

   @PostMapping("/item")
   public Grocery additem(@RequestBody Grocery obj) {
      return groceryservice.additem(obj);
   }

   @GetMapping("/item")
   public List<Grocery> allitems() {
    return groceryservice.allitems();
   }
   
   @PutMapping("/edititem/{itemid}")
   public Grocery edititem(@PathVariable Long itemid,@RequestBody Grocery obj) {

       return groceryservice.edititem(itemid,obj);
   }

   @DeleteMapping("/delitem/{itemid}")
   public String deleteitem(@PathVariable Long itemid)
   {
         groceryservice.deleteitem(itemid);
         return "Details of item "+itemid+" is successfully deleted";
   }
   
   @GetMapping("/getpriceabove1000")
   public List<Grocery> getuserwithpriceabove1000()
   {
    Double purchaseAmountThreshold = 1000.0;
    return groceryservice.findByPurchaseAmountGreaterThan(purchaseAmountThreshold);
   }
   
   @GetMapping("/sortedByItemPriceDesc")
    public List<Grocery> getEntitiesSortedByItemPriceDesc() {
        return groceryservice.getEntitiesSortedByItemPriceDesc();
    }
   
   

}