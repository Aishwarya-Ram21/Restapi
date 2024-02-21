package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Grocery;
import com.example.demo.model.User;
import com.example.demo.repository.GroceryRepo;
import com.example.demo.repository.UserRepo;

@Service
public class GroceryService {
    
    @Autowired
    GroceryRepo groceryRepo;

    @Autowired
    UserRepo userRepo;
      
    public User adduser(User obj)
    {
        return userRepo.save(obj);
    }

    public List<User> allusers()
    {
       return userRepo.findAll();
    }

    public Optional<User> getuserbyid(Long id)
    {
       return userRepo.findById(id);
    }


    public User edituser(Long userid,User obj)
    {
       User Userinfo = userRepo.findById(userid).orElse(null);
        if( Userinfo !=null)
        {    
            Userinfo.setFirstName(obj.getFirstName());
            Userinfo.setLastName(obj.getLastName());
            Userinfo.setEmailId(obj.getEmailId());
            Userinfo.setPassword(obj.getPassword());
            Userinfo.setGender(obj.getGender());
            Userinfo.setDOB(obj.getDOB());
             return userRepo.saveAndFlush(Userinfo);
        }
        else
        return null;
    }

    public void deleteuser(Long userid)
    {
        userRepo.deleteById(userid);
    }

    public Grocery additem(Grocery obj)
    {
        return groceryRepo.save(obj);
    }

    public List<Grocery> allitems()
    {
       return groceryRepo.findAll();
    }
    
    public Grocery edititem(Long itemid,Grocery obj)
    {
        Grocery Iteminfo = groceryRepo.findById(itemid).orElse(null);
        if( Iteminfo !=null)
        {    
            Iteminfo.setItemName(obj.getItemName());
            Iteminfo.setItemQuantity(obj.getItemQuantity());
            Iteminfo.setItemCategory(obj.getItemCategory());
            Iteminfo.setItemPrice(obj.getItemPrice());
           
             return groceryRepo.saveAndFlush(Iteminfo);
        }
        else
        return null;
    }

    public void deleteitem(Long itemid)
    {
        groceryRepo.deleteById(itemid);
    }
    
    
    public List<Grocery> findByPurchaseAmountGreaterThan(Double purchaseAmountThreshold) {
        
        return groceryRepo.findByItemPriceGreaterThan(purchaseAmountThreshold);
    }

    public List<Grocery> getEntitiesSortedByItemPriceDesc() {
        return groceryRepo.findByOrderByItemPriceDesc();
    }
}
