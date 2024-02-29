package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.example.demo.model.Grocery;
import com.example.demo.model.User;
import com.example.demo.repository.GroceryRepo;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
    
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

     public List<Grocery> allitems()
    {
       return groceryRepo.findAll();
    }
    
    
    public List<User> getByPaging(int pgno,int pgsize)
    {
        PageRequest page = PageRequest.of(pgno, pgsize);
        return userRepo.findAll(page).getContent();
    }
    public List<User> getBySortandPages(String field,int no,int size)
    {
        return userRepo.findAll(PageRequest.of(no, size).withSort(Sort.Direction.ASC,field)).getContent();
    }

    public List<User> getBySortedbyName(String field)
    {
        Sort sort = Sort.by(Sort.Direction.ASC,field);
        return userRepo.findAll(sort);
    }

  

}
