package com.codegym.model;

import jakarta.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartID;
    @ManyToOne
    private Account account;

}
