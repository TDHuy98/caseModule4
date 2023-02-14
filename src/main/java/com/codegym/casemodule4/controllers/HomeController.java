package com.codegym.casemodule4.controllers;

import com.codegym.casemodule4.services.CategoryService;
import com.codegym.casemodule4.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {


    CategoryService categoryService;
    ProductService productService;

    public HomeController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping({"/", "/home"})
    public String home(ModelMap model) {
        return "shop";
    }

    @GetMapping("/shop")
    public String shop(ModelMap model) {
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("products", productService.getProductsList());

        return "shop";
    }


    @GetMapping("/shop/category/{id}")
    public String shopByCategoryId(ModelMap model, @PathVariable int id) {
        model.addAttribute("categories", categoryService.getCategoryList());
        model.addAttribute("products", productService.getAllProductByCategoryId(id));
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(ModelMap model, @PathVariable Long id) {
        model.addAttribute("product", productService.getProductById(id).get());
        return "viewProduct";
    }

}
