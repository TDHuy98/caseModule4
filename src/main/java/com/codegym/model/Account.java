package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountID;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String mobile;
    private Date registeredAt;
    private Date lastLogin;
    @ManyToMany
    private List<Role> roles;

}