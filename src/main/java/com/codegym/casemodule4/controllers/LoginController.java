package com.codegym.casemodule4.controllers;


import com.codegym.casemodule4.dto.AccountToken;
import com.codegym.casemodule4.entities.Account;
import com.codegym.casemodule4.services.impl.AccountService;
import com.codegym.casemodule4.services.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    AccountService accountService;

    @PostMapping
    public AccountToken login(@RequestBody Account account){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtService.createToken(authentication);
        Account accounts = accountService.findAccountByUsername(account.getUsername());
        AccountToken accountToken = new AccountToken(accounts.getUsername(),accounts.getPassword(),token,accounts.getRoles());
        return accountToken;
    }
}