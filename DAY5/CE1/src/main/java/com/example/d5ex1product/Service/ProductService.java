package com.example.d5ex1product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.d5ex1product.model.Product;
import com.example.d5ex1product.repo.ProductRepo;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    @SuppressWarnings("null")
    public Product add(Product product)
    {
        return productRepo.save(product);
    }
    
    public List<Product> get()
    {
        return productRepo.findAll();
    }

    public Product edit(int id,Product product)
    {
        Product pa=productRepo.findById(id).orElse(null);
        if(pa!=null)
        {
            pa.setProductName(product.getProductName());
            pa.setProductDescription(product.getProductDescription());
            return productRepo.saveAndFlush(pa);
        }
        else 
        return null;
    }

    public String delete(int id)
    {
        productRepo.deleteById(id);
        return ("deleted");
    }
}
