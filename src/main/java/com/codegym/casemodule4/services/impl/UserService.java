package com.codegym.casemodule4.services.impl;


import com.codegym.casemodule4.entities.Account;
import com.codegym.casemodule4.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUsername(username);
        return new User(account.getUsername(),account.getPassword(),account.getRoles());
    }
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    public void save(Account account){
        accountRepository.save(account);
    }

}
