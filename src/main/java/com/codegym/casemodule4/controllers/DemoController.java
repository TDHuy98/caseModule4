package com.codegym.casemodule4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class DemoController {
    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("pageName", "OrderManagment");
        return "admin/OrderManagement";
    }
}