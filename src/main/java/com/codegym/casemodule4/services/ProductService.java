package com.codegym.casemodule4.services;

import com.codegym.casemodule4.entities.Product;

import com.codegym.casemodule4.repositories.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProduct iProduct;

    public List<Product> findAll() {
        return (List<Product>) iProduct.findAll();
    }

    public Product save(Product product) {
        return iProduct.save(product);
    }

    public Product deleteById(Long id){
        Product product = iProduct.findById(id).get();
        iProduct.deleteById(id);
        return product;
    }

    public Product findById(Long id) {
        return   iProduct.findById(id).get();
    }

}
