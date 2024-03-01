package com.example.d5ex1product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.d5ex1product.Service.ProductService;
import com.example.d5ex1product.model.Product;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public Product add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/get")
    public List<Product> get() {
        return productService.get();
    }

    @PutMapping("/edit/{id}")
    public Product edit(@PathVariable int id, @RequestBody Product product) {
        return productService.edit(id,product);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id )
    {
        return productService.delete(id);
    }

}
