package com.codegym.casemodule4.controllers;

import com.codegym.casemodule4.entities.Product;
import com.codegym.casemodule4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/home")
@CrossOrigin("*")
public class UserController {
    @Autowired
    ProductService productService;

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return productService.search(name);
    }
}


