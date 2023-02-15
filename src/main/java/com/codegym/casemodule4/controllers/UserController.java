package com.codegym.casemodule4.controllers;

import com.codegym.casemodule4.entities.Product;
import com.codegym.casemodule4.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")

public class UserController {

    ProductService productService;

    public UserController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("search", productService.search(name));
        return modelAndView;
    }
}


