package com.codegym.casemodule4.services;


import com.codegym.casemodule4.entities.Product;
import com.codegym.casemodule4.repositories.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    IProductRepo iProductRepo;
    public List<Product> search(String name){
        return iProductRepo.search(name);
    }
}
