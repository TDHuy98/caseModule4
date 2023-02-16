package com.codegym.casemodule4.services.impl;

import com.codegym.casemodule4.entities.User;
import com.codegym.casemodule4.entities.UserDetail;
import com.codegym.casemodule4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    //Tim kiem user theo username. Neu k co thi tao moi
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng"));
        return user.map(UserDetail::new).get();
    }
}
