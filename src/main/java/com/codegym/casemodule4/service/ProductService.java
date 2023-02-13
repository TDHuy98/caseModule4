package com.codegym.casemodule4.service;

import com.codegym.casemodule4.entities.Product;
import com.codegym.casemodule4.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> search(String name) {
        return productRepository.search(name);
    }
}