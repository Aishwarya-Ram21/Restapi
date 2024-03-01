package com.example.d5ex1product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.d5ex1product.model.Product;

@Repository
public  interface ProductRepo extends JpaRepository<Product,Integer>{
    
}
