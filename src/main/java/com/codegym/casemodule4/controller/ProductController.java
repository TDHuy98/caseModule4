package com.codegym.casemodule4.controller;


import com.codegym.casemodule4.entities.Product;
import com.codegym.casemodule4.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    HttpSession httpSession;


    @GetMapping
    public List<Product> show() {

        return productService.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return  productService.save(product);

    }

//    @PostMapping("/upImg")
//    public String upImg(@RequestParam MultipartFile fileImg) {
//        String nameImg = fileImg.getOriginalFilename();
//        try {
//            FileCopyUtils.copy(fileImg.getBytes(), new File("C:\\Users\\hoang\\Desktop\\caseModule4\\src\\main\\resources\\img/" + nameImg));
//            return "/img/" + nameImg;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }


    @GetMapping("/{id}")
    public Product showEdit(@PathVariable Long id){
        return  productService.findById(id);
    }


    @PutMapping("/{id}")
    public Product edit(@RequestBody Product product) {
        return productService.save(product);
    }



    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Long id) {
        return productService.deleteById(id);
    }


}
