package com.codegym.casemodule4.controllers;

import com.codegym.casemodule4.entities.Product;
import com.codegym.casemodule4.global.GlobalData;
import com.codegym.casemodule4.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CartController {
    @Autowired
    ProductService productService;

    @GetMapping("/addtoCart/{id}")
    public String addToCart(@PathVariable Long id) {
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";

    }


    @GetMapping("/cart")
    public String cartGet(ModelMap model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index){
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(ModelMap model){
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }
}
