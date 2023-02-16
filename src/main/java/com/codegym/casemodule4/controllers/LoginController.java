package com.codegym.casemodule4.controllers;

import com.codegym.casemodule4.entities.Role;
import com.codegym.casemodule4.entities.User;
import com.codegym.casemodule4.global.GlobalData;
import com.codegym.casemodule4.repositories.UserRepository;
import com.codegym.casemodule4.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        Optional<User> userDifine=userRepository.findUserByUserName(user.getUserName());
        GlobalData.cart.clear();
        return "login";
    }


    @GetMapping("/register")
    public String registerGET(ModelMap model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerPOST(@ModelAttribute("user") User user){
        String password=user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(2).get());
        user.setRoles(roles);
        userRepository.save(user);
        return "redirect:/";
    }
}
